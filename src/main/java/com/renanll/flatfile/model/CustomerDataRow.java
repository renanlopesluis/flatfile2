package com.renanll.flatfile.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CustomerDataRow extends DataRow{
	private String cnpj;
	private String name;
	private String businessArea;
}
