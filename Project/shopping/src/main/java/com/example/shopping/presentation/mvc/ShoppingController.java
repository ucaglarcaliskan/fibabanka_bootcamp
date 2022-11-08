package com.example.shopping.presentation.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.shopping.business.dto.CartProductDto;

@Controller
public class ShoppingController {

	@GetMapping("/test/shopping/cart/add")
	@ResponseBody
	public String postProduct() {
		CartProductDto cartProductDto = new CartProductDto(0, 1, 1, 1, 11200, 11200);
		String url = "http://localhost:8082/shopping/cart/add";
		RestTemplate restTemplate = new RestTemplate();
		CartProductDto result = restTemplate.postForObject(url, cartProductDto, CartProductDto.class);
		return "Yollama Başarılı: " + result;
	}
	// TODO Test
}
