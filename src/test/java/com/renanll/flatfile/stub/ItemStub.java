package com.renanll.flatfile.stub;

import com.renanll.flatfile.model.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ItemStub {
    public static List<Item> buildList(){
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, new BigDecimal("100"), 10));
        items.add(new Item(2, new BigDecimal("2.50"), 30));
        items.add(new Item(3, new BigDecimal("3.10"), 40));
        return items;
    }
}
