package com.renanll.flatfile.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Item {
	private Integer id;
	private BigDecimal price;
	private Integer quantity;
	public BigDecimal getTotalPrice() {
		return price.multiply(new BigDecimal(quantity));
	}
}