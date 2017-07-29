package com.rentCar;

/**
 * Created by qmm on 17-7-28.
 */
public class PickUpCar extends Car implements LoadGoods, LoadPerson {
    private int person;
    private int goods;

    //构造函数
    public PickUpCar(int newId, String newName, int newPrice, int newGoods, int newPerson) {
        setProperties(newId, newName, newPrice);
        setGoods(newGoods);
        setPerson(newPerson);
    }

    @Override//覆盖接口中的抽象方法
    public int getPerson() {
        return person;
    }

    @Override//覆盖接口中的抽象方法
    public void setPerson(int newPerson) {
        this.person = newPerson;
    }

    @Override //覆盖接口中的抽象方法
    public int getGoods() {
        return goods;
    }

    @Override//覆盖接口中的抽象方法
    public void setGoods(int newGoods) {
        this.goods = newGoods;
    }

    public void setProperties(int newId, String newName, int newPrice) {
        this.id = newId;
        this.name = newName;
        this.price = newPrice;
    }


    public String toString() {
        return id + ". " + name + "\t" + price + "元/天 " + "载人：" + getPerson() + "人" + " " + "载货：" + getGoods() + " 吨";
    }

}
