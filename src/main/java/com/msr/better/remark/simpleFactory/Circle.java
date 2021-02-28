package com.msr.better.remark.simpleFactory;

/**
 * @author MaiShuRen
 * @date 2020-10-20
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
