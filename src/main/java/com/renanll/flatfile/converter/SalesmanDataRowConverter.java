package com.renanll.flatfile.converter;

import com.renanll.flatfile.model.DataRow;
import com.renanll.flatfile.model.SalesmanDataRow;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SalesmanDataRowConverter extends DataRowConverter{
	
	private static final int CPF_INDEX = 1;
	private static final int NAME_INDEX = 2;
	private static final int SALARY_INDEX = 3;

	@Override
	public DataRow convert(String row) {
		String[] data = row.split(SPLITTER);
		String cpf = data[CPF_INDEX];
		String name = data[NAME_INDEX];
		BigDecimal salary = new BigDecimal(data[SALARY_INDEX]);
		return new SalesmanDataRow(cpf, name, salary);
	}
}
