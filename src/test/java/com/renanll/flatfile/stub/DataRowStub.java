package com.renanll.flatfile.stub;

import com.renanll.flatfile.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DataRowStub {

    public static List<DataRow> build(){
        List<DataRow> dataRows  = new ArrayList<>();
        List<Item> items = new ArrayList<>();
        dataRows.add(new SalesmanDataRow("123", "Matilda", new BigDecimal("3000.89")));
        dataRows.add(new SalesmanDataRow("353", "Rambo", new BigDecimal("1000.20")));
        dataRows.add(new SalesmanDataRow("201", "Joey", new BigDecimal("1502.65")));

        dataRows.add(new CustomerDataRow("321", "Ellen Page", "Comercio"));
        dataRows.add(new CustomerDataRow("576", "Norton", "Rural"));
        dataRows.add(new CustomerDataRow("798", "François", "Comercio"));
        dataRows.add(new CustomerDataRow("808", "Durden", "Rural"));

        items.add(new Item(1, new BigDecimal ("5"),3 ));
        dataRows.add(new SalesDataRow(10L, items, "Matilda"));

        items = new ArrayList<>();
        items.add(new Item(3, new BigDecimal("1"), 1));
        dataRows.add(new SalesDataRow(11L, items, "Rambo"));

        items = new ArrayList<>();
        items.add(new Item(1, new BigDecimal("3"), 4));
        items.add(new Item(2, new BigDecimal("2"), 8));
        dataRows.add(new SalesDataRow(12L, items, "Joey"));

        return dataRows;
    }
}
