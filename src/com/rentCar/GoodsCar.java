package com.rentCar;

/**
 * Created by qmm on 17-7-28.
 */
public class GoodsCar extends Car implements LoadGoods {
    private int goods;//私有属性，载货量

    //构造函数，构建实例化对象初始化
    public GoodsCar(int newId, String newName, int newPrice,int newGoods){
        setProperties(newId, newName, newPrice);
        setGoods(newGoods);
    }

    @Override //覆盖接口中的抽象方法
    public void setGoods(int newGoods){

        this.goods = newGoods;
    }

    @Override //覆盖接口中的抽象方法
    public int getGoods(){

        return goods;
    }

    @Override//覆盖父类中的抽象方法
    public void setProperties(int newId, String newName, int newPrice){
        this.id = newId;
        this.name = newName;
        this.price = newPrice;
    }

    public String toString(){

        return id +".  " + name + "\t" + price + "元／天　"+"载货："+getGoods()+"　吨";
    }
}
