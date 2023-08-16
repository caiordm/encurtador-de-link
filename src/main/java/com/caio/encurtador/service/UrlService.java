package com.caio.encurtador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.caio.encurtador.model.Url;
import com.caio.encurtador.repository.UrlRepository;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UrlService {
	private final UrlRepository urlRepository;
	
	@Autowired
	public UrlService(UrlRepository urlRepository) {
		this.urlRepository = urlRepository;
	}
	
	public ResponseEntity<String> createUrl(Url url) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		url.setHash(getHash(url.getUrlOriginal()));
		url.setUrlEncurtada("http://localhost/" + url.getHash());
		urlRepository.save(url);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("URL encurtada com sucesso!");
	}
	
	public List<Url> getAll() {
		return urlRepository.findAll();
	}
	
	public ResponseEntity<String> getEncurtada(String hash) {
		String urlOriginal = urlRepository.findByHashManual(hash);
		return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT).location(URI.create(urlOriginal)).build();
	}
	
	public String getHash(String texto) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		BigInteger hash = new BigInteger(1, md.digest(texto.getBytes()));
        return hash.toString(16).substring(26);
	}

}
