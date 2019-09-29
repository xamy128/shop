package com.sample.shop.persistence.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter @Setter @NoArgsConstructor
class TestEntity {

    BigDecimal bb = BigDecimal.ZERO;

    public void swap(int a, int b) {
        //a =10
        //b=20
        int c = a; //10
        a=b; //20
        b=c; //10

    }

    public static void main(String[] args) {
        int a= 10;
        int b=20;

        TestEntity testEntity = new TestEntity();

        System.out.println("a: " +a +" b: " + b);
        testEntity.swap(a,b);

        System.out.println("After swap: a: "+a+" b: "+b);

        ArrayList<Integer> aa = new ArrayList<>();
        aa.add(4);
        ArrayList<Integer> bb = aa;
        bb.add(3);

        aa.stream().forEach(System.out::print);
        System.out.println("");
        bb.stream().forEach(System.out::print);

    Integer haha = 4;
    Integer hehe = haha;
    hehe = 56;
        System.out.println("haha: "+haha + " hehe "+ hehe);
    }
}
