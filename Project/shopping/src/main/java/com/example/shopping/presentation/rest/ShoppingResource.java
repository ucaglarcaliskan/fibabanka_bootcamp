package com.example.shopping.presentation.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping.business.dto.CartDto;
import com.example.shopping.business.dto.CartProductDto;
import com.example.shopping.business.service.CartProductService;
import com.example.shopping.business.service.CartService;

@RestController
@RequestMapping("/shopping")
public class ShoppingResource {

	@Autowired
	private CartService cartService;

	@Autowired
	private CartProductService cartProductService;

	@GetMapping("/cart/create")
	public long createCart() {
		long cartId = cartService.createCart();
		return cartId;
	}

	@PostMapping("/cart/add")
	public void addProductToCart(@RequestBody CartProductDto cartProductDto) {
		System.out.println(cartProductDto);
		cartProductService.addCartProduct(cartProductDto);
	}

	@DeleteMapping("/cart/{cartId}/remove/{productId}")
	public void deleteProductFromCart(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {
		cartProductService.deleteProduct(cartId, productId);
	}

	@GetMapping("/checkout/{cartId}")
	public void checkout(@PathVariable("cartId") long cartId) {
		cartService.checkoutCart(cartId);
	}

	@GetMapping("/cart/find/{cartId}")
	public CartDto findCart(@PathVariable("cartId") long cartId) {
		CartDto cartDto = cartService.find(cartId);
		return cartDto;
	}
}
