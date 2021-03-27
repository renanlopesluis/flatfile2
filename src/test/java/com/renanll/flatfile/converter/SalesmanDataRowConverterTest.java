package com.renanll.flatfile.converter;

import com.renanll.flatfile.model.DataRow;
import com.renanll.flatfile.model.SalesmanDataRow;
import com.renanll.flatfile.stub.SalesmanDataRowStub;
import org.junit.Assert;
import org.junit.Test;

public class SalesmanDataRowConverterTest {

    @Test
    public void shouldConvertIntoSalesDataRow() throws Exception {
        final String given = "001ç3245678865434çRenatoç40000.99";
        Converter<DataRow> converter = new SalesmanDataRowConverter();

        SalesmanDataRow expected = SalesmanDataRowStub.build();
        SalesmanDataRow actual = (SalesmanDataRow) converter.convert(given);

        Assert.assertEquals(expected, actual);
    }
}
