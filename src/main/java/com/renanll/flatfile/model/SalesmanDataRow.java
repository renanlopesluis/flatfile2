package com.renanll.flatfile.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SalesmanDataRow extends DataRow{
	
	private String cpf;
	private String name;
	private BigDecimal salary;
}
