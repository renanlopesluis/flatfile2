package com.renanll.flatfile.enumeration;

import com.renanll.flatfile.exception.NoSuchEnumException;
import org.junit.Assert;
import org.junit.Test;

public class DataRowTypeEnumTest {

    @Test
    public void shouldGetADataRowTypeEnum() throws NoSuchEnumException {
        final String given = "001";

        DataRowTypeEnum actual = DataRowTypeEnum.getFromId(given);

        Assert.assertEquals(DataRowTypeEnum.SALESMAN, actual);
    }

    @Test(expected = NoSuchEnumException.class)
    public void shouldNotGetADataRowTypeEnum() throws NoSuchEnumException {
        final String given = "005";

        DataRowTypeEnum.getFromId(given);
    }
}
