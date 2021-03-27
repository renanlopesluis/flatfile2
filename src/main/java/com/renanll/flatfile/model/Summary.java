package com.renanll.flatfile.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class Summary {
	
	private Integer clientsAmount;
	private Integer salesmenAmount;
	private Long mostExpensiveSaleId;
	private String worstSalesman;

	public List<String> toLines() {
		List<String> lines = new ArrayList<>();
		lines.add("Amount of clients: " + this.clientsAmount);
		lines.add("Amount of salesmen: " + this.salesmenAmount);
		lines.add("ID of the most expensive sale: " + this.mostExpensiveSaleId);
		lines.add("Worst salesman ever: " + this.worstSalesman);
		return lines;
	}

}
