package com.msr.better.remark.simpleFactory;

/**
 * 图形工厂
 *
 * @author MaiShuRen
 * @date 2020-10-20
 */
public class ShapeFactory {

    /**
     * 获取形状类型的对象
     */
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if("CIRCLE".equalsIgnoreCase(shapeType)){
            return new Circle();
        } else if("RECTANGLE".equalsIgnoreCase(shapeType)){
            return new Rectangle();
        }
        return null;
    }
}
