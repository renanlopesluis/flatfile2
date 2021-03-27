package com.renanll.flatfile.enumeration;

import java.util.Arrays;
import java.util.List;

import com.renanll.flatfile.exception.NoSuchEnumException;
import com.renanll.flatfile.converter.CustomerDataRowConverter;
import com.renanll.flatfile.converter.DataRowConverter;
import com.renanll.flatfile.converter.SalesDataRowConverter;
import com.renanll.flatfile.converter.SalesmanDataRowConverter;
import lombok.Getter;

@Getter
public enum DataRowTypeEnum {

	SALESMAN	("001", new SalesmanDataRowConverter()),
	CUSTOMER	("002", new CustomerDataRowConverter()),
	SALE		("003", new SalesDataRowConverter());
	
	private String id;
	private DataRowConverter converter;
	
	DataRowTypeEnum(String id, DataRowConverter converter) {
		this.id = id;
		this.converter = converter;
	}
	
	public static DataRowTypeEnum getFromId(String id) throws NoSuchEnumException {
		List<DataRowTypeEnum> types = Arrays.asList(values());
		return types.stream().filter(x -> x.id.equals(id)).findFirst()
				.orElseThrow(() -> new NoSuchEnumException("No such enum found for this id"));
	}
}
