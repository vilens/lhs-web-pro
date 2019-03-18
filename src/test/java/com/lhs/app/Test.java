package com.lhs.app;

import com.lhs.entity.Classify;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fancy on 2018/7/11.
 */
public class Test {

    public static void main(String[] args) {
        List<Classify> classifyList = new ArrayList<>();
        Classify classify = new Classify();
        classify.setId(1L);
        classify.setName("test1");
        classifyList.add(classify);

        classify = new Classify();
        classify.setId(2L);
        classify.setName("test2");
        classifyList.add(classify);



        System.out.println(classifyList.stream().map(e -> e.getId()).collect(Collectors.toList()));
    }
}
