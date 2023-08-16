package com.caio.encurtador.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caio.encurtador.model.Url;
import com.caio.encurtador.service.UrlService;

@RestController
public class UrlController {
	private UrlService urlService;
	
	@Autowired
	public UrlController(UrlService urlService) {
		this.urlService = urlService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody Url url) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return urlService.createUrl(url);
	
	}
	
	@GetMapping("/getAll")
	public List<Url> getAll() {
		return urlService.getAll();
	}
	
	@GetMapping("/{hash}")
	public ResponseEntity<String> getEncurtada(@PathVariable String hash) {
		return urlService.getEncurtada(hash);
	}
	
	@PostMapping("/teste")
	public String teste(@RequestBody String texto) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return urlService.getHash(texto);
	}
}
