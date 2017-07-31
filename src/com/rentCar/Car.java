package com.rentCar;

/**
 * Created by qmm
 * on 17-7-28.
 */
public abstract class   Car {
    public int id;//序号
    public String name;//车名
    public int price;//租金

    //抽象方法，设置属性
    public abstract void setProperties(int newId,String newName,int newPrice);

}
