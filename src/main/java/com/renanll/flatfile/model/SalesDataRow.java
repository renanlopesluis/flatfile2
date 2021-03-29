package com.renanll.flatfile.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SalesDataRow extends DataRow {
	
	private Long id;
	private List<Item> items;
	private String salesmanName;

	public Boolean hasSalesmanNamed(String salesmanName) {
		return this.salesmanName.equals(salesmanName);
	}
	
	public BigDecimal getSaleTotalAmount() {
		Optional<BigDecimal> total = items.stream().map((x) -> x.getTotalPrice())
				.reduce((x, y) -> x.add(y));
		if(total.isPresent()){
			return total.get();
		}
		return new BigDecimal(0);
	}
	
}
