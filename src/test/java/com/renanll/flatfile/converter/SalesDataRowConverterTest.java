package com.renanll.flatfile.converter;

import com.renanll.flatfile.model.DataRow;
import com.renanll.flatfile.model.SalesDataRow;
import com.renanll.flatfile.stub.SalesDataRowStub;
import org.junit.Assert;
import org.junit.Test;

public class SalesDataRowConverterTest {

    @Test
    public void shouldConvertIntoSaleDataRow() throws Exception {
        final String given = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego";
        Converter<DataRow>  converter = new SalesDataRowConverter();

        SalesDataRow expected = SalesDataRowStub.build();
        SalesDataRow actual = (SalesDataRow) converter.convert(given);

        Assert.assertEquals(expected, actual);
    }

}
