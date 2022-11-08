package com.example.shopping.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping.business.dto.CartDto;
import com.example.shopping.business.dto.CartProductDto;
import com.example.shopping.data.entity.Cart;
import com.example.shopping.data.entity.CartProduct;
import com.example.shopping.data.repository.CartProductRepository;
import com.example.shopping.data.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	private CartRepository cartRepository;
	private CartProductRepository cartProductRepository;

	@Autowired
	private CartProductService cartProductService;

	public CartServiceImpl(CartRepository cartRepository, CartProductRepository cartProductRepository) {
		this.cartRepository = cartRepository;
		this.cartProductRepository = cartProductRepository;
	}

	@Override
	public long createCart() {
		Cart cart = cartRepository.save(new Cart());
		return cart.getCartId();
	}

	@Override
	public CartDto find(long cartId) {
		Optional<Cart> optional = cartRepository.findById(cartId);
		if (!optional.isPresent()) {
			System.out.println("Sepet bulunamadı.");
			return null;
		}
		Cart cart = optional.get();
		List<CartProduct> cartProducts = cartProductRepository.findByCartId(cartId);

		List<CartProductDto> cartProductDtos = new ArrayList<>();
		for (CartProduct cartProduct : cartProducts) {
			cartProductDtos.add(cartProductService.toDto(cartProduct));
		}
		CartDto cartDto = toDto(cart, cartProductDtos);
		return cartDto;
	}

	@Override
	public void checkoutCart(long cartId) {
		Optional<Cart> optional = cartRepository.findById(cartId);
		if (!optional.isPresent()) {
			System.out.println("Ödeme yapmak için sepet bulunamadı.");
			return;
		}
		Cart cart = optional.get();
		cart.setCartStatus(1);
		cartRepository.save(cart);
	}

	public CartDto toDto(Cart cart, List<CartProductDto> cartProducts) {
		CartDto cartDto = new CartDto(cart.getCartId(), cart.getCustomerName(), cartProducts);
		return cartDto;
	}
}
