package com.msr.better.remark.simpleFactory;

/**
 * @author MaiShuRen
 * @date 2020-10-20
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
