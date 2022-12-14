package com.example.shopping.business.service;

import org.springframework.stereotype.Service;

import com.example.shopping.business.dto.CartProductDto;
import com.example.shopping.data.entity.CartProduct;
import com.example.shopping.data.repository.CartProductRepository;

@Service
public class CartProductServiceImpl implements CartProductService {

	private CartProductRepository cartProductRepository;

	public CartProductServiceImpl(CartProductRepository cartProductRepository) {
		this.cartProductRepository = cartProductRepository;
	}

	@Override
	public void deleteProduct(long cartId, long productId) {
		CartProduct cartProduct = cartProductRepository.findByCartIdAndProductId(cartId, productId);
		if (cartProduct.getSalesQuantity() > 1) {
			cartProduct.setSalesQuantity(cartProduct.getSalesQuantity() - 1);
			cartProductRepository.save(cartProduct);
		} else {
			cartProductRepository.deleteByCartIdAndProductId(cartId, productId);
		}
	}

	@Override
	public void addCartProduct(CartProductDto cartProductDto) {
		CartProduct cartProduct = cartProductRepository.findByCartIdAndProductId(cartProductDto.getCartId(),
				cartProductDto.getProductId());
		if (cartProduct != null) {
			cartProduct.setSalesQuantity(cartProduct.getSalesQuantity() + cartProductDto.getSalesQuantity());
			cartProductRepository.save(cartProduct);
		} else {
			cartProductRepository.save(toEntity(cartProductDto));
		}
	}

	public CartProduct toEntity(CartProductDto cartProductDto) {
		CartProduct cartProduct = new CartProduct(cartProductDto.getCartProductId(), cartProductDto.getCartId(),
				cartProductDto.getProductId(), cartProductDto.getSalesQuantity(), cartProductDto.getSalesPrice(),
				cartProductDto.getLineAmount());
		return cartProduct;
	}

	public CartProductDto toDto(CartProduct cartProduct) {
		CartProductDto cartProductDto = new CartProductDto(cartProduct.getCartProductId(), cartProduct.getCartId(),
				cartProduct.getProductId(), cartProduct.getSalesQuantity(), cartProduct.getSalesPrice(),
				cartProduct.getLineAmount());
		return cartProductDto;
	}
}
