package com.rentCar;

/**
 * Created by qmm on 17-7-28.
 */

//客车类，继承Car类，因为是客车，所以只需要实现　载人　接口即可
public class PersonCar extends Car implements LoadPerson {
    private int person; //私有属性，载客量

    //构造函数
    public PersonCar(int newId, String newName, int newPrice, int newPerson) {

        //设置属性
        setProperties(newId, newName, newPrice);

        //设置载客量
        setPerson(newPerson);
    }

    @Override //覆盖接口中的抽象方法
    public int getPerson() {
        return person;
    }

    @Override   //覆盖接口中的抽象方法
    public void setPerson(int newPerson) {
        this.person = newPerson;
    }

    @Override//覆盖父类中的抽象方法
    public void setProperties(int newId, String newName, int newPrice) {
        this.id = newId;
        this.name = newName;
        this.price = newPrice;
    }

    //此处注意：要覆盖Ｏｂｊｅｃｔ类中的toString方法，方便打印实例对象时输出字符串而不是地址
    public String toString() {

        return id + ".  " + name + "\t" + price + "元／天   " + "载人：" + getPerson() + "　人";
    }


}
