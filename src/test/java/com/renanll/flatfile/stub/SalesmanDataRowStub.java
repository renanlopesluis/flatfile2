package com.renanll.flatfile.stub;

import com.renanll.flatfile.model.SalesmanDataRow;

import java.math.BigDecimal;

public class SalesmanDataRowStub {

    public static SalesmanDataRow build(){
        return new SalesmanDataRow("3245678865434", "Renato", new BigDecimal("40000.99"));
    }
}
