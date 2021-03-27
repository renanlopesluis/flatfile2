package com.renanll.flatfile.stub;

import com.renanll.flatfile.model.Summary;

public class SummaryStub {

    public static Summary build(){
        return Summary.builder()
                .clientsAmount(2)
                .worstSalesman("Renato")
                .mostExpensiveSaleId(10L)
                .salesmenAmount(2)
                .build();
    }
}
