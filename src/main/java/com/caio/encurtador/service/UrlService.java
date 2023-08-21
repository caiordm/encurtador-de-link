package com.caio.encurtador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.caio.encurtador.dto.UrlUser;
import com.caio.encurtador.model.Url;
import com.caio.encurtador.model.User;
import com.caio.encurtador.repository.UrlRepository;
import com.caio.encurtador.repository.UserRepository;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UrlService {
	private final UrlRepository urlRepository;
	private final UserRepository userRepository;
	
	@Autowired
	public UrlService(UrlRepository urlRepository, UserRepository userRepository) {
		this.urlRepository = urlRepository;
		this.userRepository =userRepository;
	}
	
	public ResponseEntity<String> createUrl(Url url) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		url.setHash(getHash(url.getUrlOriginal()));
		url.setUrlEncurtada("http://localhost:8080/" + url.getHash());
		urlRepository.save(url);
		
		String jsonResponse = "{\"urlEncurtada\": \"" + url.getUrlEncurtada() + "\"}";
		
		return ResponseEntity.status(HttpStatus.CREATED).body(jsonResponse);
	}
	
	public List<Url> getAll() {
		return urlRepository.findAll();
	}
	
	public ResponseEntity<String> getEncurtada(String hash) {
		String urlOriginal = urlRepository.findByHashManual(hash);
		return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT).location(URI.create(urlOriginal)).build();
	}
	
	public ResponseEntity<String> associaUser(UrlUser urlUser) {
		User user = userRepository.findById(urlUser.getUser()).orElse(null);
		Url url = urlRepository.findById(urlUser.getUrl()).orElse(null);
		
		url.setUser(user);
		
		urlRepository.save(url);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Associado");
	}
	
	public String getHash(String texto) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		BigInteger hash = new BigInteger(1, md.digest(texto.getBytes()));
        return hash.toString(16).substring(26);
	}

}
