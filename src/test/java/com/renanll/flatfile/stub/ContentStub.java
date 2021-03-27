package com.renanll.flatfile.stub;

import java.util.ArrayList;
import java.util.List;

public class ContentStub {

    public static List<String> build(){
        List<String> lines = new ArrayList<>();

        lines.add("001ç1234567891234çDiegoç50000");
        lines.add("001ç3245678865434çRenatoç40000.99");
        lines.add("002ç2345675434544345çJose da SilvaçRural");
        lines.add("002ç2345675433444345çEduardo PereiraçRural");
        lines.add("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego");
        lines.add("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenato");

        return lines;
    }
}
