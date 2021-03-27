package com.renanll.flatfile.converter;

import com.renanll.flatfile.model.CustomerDataRow;
import com.renanll.flatfile.model.DataRow;
import com.renanll.flatfile.stub.CustomerDataRowStub;
import org.junit.Assert;
import org.junit.Test;

public class CustomerDataRowConverterTest {

    @Test
    public void shouldConvertIntoCustormerDataRow() throws Exception{
        final String given = "002ç2345675434544345çJose da SilvaçRural";
        Converter<DataRow> converter = new CustomerDataRowConverter();

        CustomerDataRow expected = CustomerDataRowStub.build();
        CustomerDataRow actual = (CustomerDataRow) converter.convert(given);

        Assert.assertEquals(expected, actual);
    }
}
