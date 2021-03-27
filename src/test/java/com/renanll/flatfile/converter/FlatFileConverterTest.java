package com.renanll.flatfile.converter;

import com.renanll.flatfile.model.CustomerDataRow;
import com.renanll.flatfile.model.DataRow;
import com.renanll.flatfile.model.SalesDataRow;
import com.renanll.flatfile.model.SalesmanDataRow;
import com.renanll.flatfile.stub.CustomerDataRowStub;
import com.renanll.flatfile.stub.SalesDataRowStub;
import com.renanll.flatfile.stub.SalesmanDataRowStub;
import org.junit.Assert;
import org.junit.Test;

public class FlatFileConverterTest {

	private String errorMessage;

	@Test
	public void shouldConvertIntoSalesmanDataRow() throws Exception {
		final String given = "001ç3245678865434çRenatoç40000.99";
		Converter<DataRow> converter = new FlatFileConverter();

		SalesmanDataRow expected = SalesmanDataRowStub.build();
		SalesmanDataRow actual = (SalesmanDataRow) converter.convert(given);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void shouldConvertIntoCustormerDataRow() throws Exception {
		Converter<DataRow>  converter = new FlatFileConverter();
		final String given = "002ç2345675434544345çJose da SilvaçRural";

		CustomerDataRow expected = CustomerDataRowStub.build();
		CustomerDataRow actual = (CustomerDataRow) converter.convert(given);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void shouldConvertIntoSaleDataRow() throws Exception {
		Converter<DataRow>  converter = new FlatFileConverter();
		final String given = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego";

		SalesDataRow expected = SalesDataRowStub.build();
		SalesDataRow actual = (SalesDataRow) converter.convert(given);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void shouldNotConvertIntoAnyDataRow() {
		DataRow dataRow = null;
		try {
			Converter<DataRow>  converter = new FlatFileConverter();
			dataRow = converter.convert("004ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego");
		} catch (Exception ex) {
			errorMessage = ex.getMessage();
		} finally {
			Assert.assertNull(dataRow);
			Assert.assertNotNull(errorMessage);
			Assert.assertEquals("No such enum found for this id", errorMessage);
		}
	}
}