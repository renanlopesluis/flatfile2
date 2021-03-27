package com.renanll.flatfile.converter;

import com.renanll.flatfile.model.DataRow;
import com.renanll.flatfile.model.Item;
import com.renanll.flatfile.model.SalesDataRow;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalesDataRowConverter extends DataRowConverter{
		
	private static final int ID_SALE_INDEX = 1;
	private static final int ITEMS_INDEX = 2;
	private static final int NAME_SALESMAN_INDEX = 3;
		
	@Override
	public DataRow convert(String row) {
		ItemConverter itemConverter = new ItemConverter();
		String[] data = row.split(SPLITTER);
		Long id = new Long(data[ID_SALE_INDEX]);
		String nameSalesman = data[NAME_SALESMAN_INDEX];
		List<Item> items = itemConverter.convertItems(data[ITEMS_INDEX]);
		return new SalesDataRow(id, items, nameSalesman);
	}
}
