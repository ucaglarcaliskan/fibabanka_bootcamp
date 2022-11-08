package com.example.demo.resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferResource {
	
	@GetMapping("/transfer/header")
	public ResponseEntity<?> getHeader(@RequestHeader(value = "input", defaultValue = "Boş") String input) {
		String output = "Giren: " + input;
		System.out.println("Çıktı> :" + input);
		return ResponseEntity.ok(output);
	}
	
	@GetMapping("/transfer/setheader")
	public ResponseEntity<?> setHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("input", "Godoro");
		return ResponseEntity.ok().headers(headers).body("Başlık Gönderildi");
	}
}
