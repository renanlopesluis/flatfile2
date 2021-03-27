package com.renanll.flatfile.stub;

import com.renanll.flatfile.model.SalesDataRow;

public class SalesDataRowStub {

    public static SalesDataRow build(){
        return new SalesDataRow(10L,  ItemStub.buildList(), "Diego");
    }
}
