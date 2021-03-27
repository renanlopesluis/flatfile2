package com.renanll.flatfile.converter;


import com.renanll.flatfile.enumeration.DataRowTypeEnum;
import com.renanll.flatfile.model.DataRow;
import org.springframework.stereotype.Component;

@Component
public class FlatFileConverter implements Converter<DataRow>{
	
	private static final int ID_BEGIN = 0;
	private static final int ID_END = 3;

	@Override
	public DataRow convert(String row) throws Exception{
		String id = row.substring(ID_BEGIN, ID_END);
		DataRowTypeEnum typeDataEnum = DataRowTypeEnum.getFromId(id);
		return typeDataEnum.getConverter().convert(row);
	}

}
