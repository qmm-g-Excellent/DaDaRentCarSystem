package com.rentCar;

import java.util.Scanner;

public class UsersMain {

    private static int rentDay, rentNum;//租车天数，租车数量
    private static int allPerson;//所有载客量
    private static int allGoods;//所有载货量
    private static int allMoney;//所有租金
    private static int[] idNum;//存储选择的车型序号

    private static Car[] cars = {
            new PersonCar(1, "奥迪Ａ4", 500, 4),
            new PersonCar(2, "马自达6", 400, 4),
            new PersonCar(3, "金龙", 800, 20),
            new GoodsCar(4, "松花江", 400, 4),
            new GoodsCar(5, "依维柯", 1000, 20),
            new PickUpCar(6, "皮卡雪6", 450, 4, 2),
    };

    public static void main(String args[]) {
        System.out.println("欢迎使用答答租车系统！");
        System.out.println("您是否要租车？(1 是　　0否)　请选择");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();//调用键盘输入

        if (choice != 1) {
            System.out.println("欢迎再次光临！");
        } else {
            //打车信息
            System.out.println("您可租车的类型及其价目表如下所示：");
            System.out.println("序号　　　　汽车类型　　　　租金　　　　容量");
            for (Car car : cars) {
                System.out.println(car);
            }
        }

        System.out.println("请输入您要租车的数量（１辆起租）：");
        rentNum = input.nextInt();
        idNum = new int[rentNum];//创建一个租车数量长度的id数组，存储输入的id
        for (int i = 1; i <= rentNum; i++) {
            System.out.println("请输入第" + i + "辆车的序号：");
            idNum[i - 1] = input.nextInt();
        }

        System.out.println("请输入租车的天数：");
        rentDay = input.nextInt();
        input.close();//关闭Scanner　不然会有警告

        //打印账单
        new UsersMain().printBill();
    }

    public void printBill() {
        String strPerson = "";//载人车型名称　必须要先初始化赋值，不然后面会报错
        String strGoods = ""; //载货车型名称

        for (int carId : idNum) {
            for (Car car : cars) {
                if (car.id == carId) {
                    //先计算租金，因为租金不受车型影响
                    allMoney += car.price;

                    /*再逐个判断是哪种车型 *关键字instanceof 判断一个实例是否是某个类的对象 返回boolean量
                    /*也可使用getClass()函数做判断 ：if(car.getClass == PersonCar.class )
                    /*每个Id 都只能执行其中一个if代码块 */

                    if (car instanceof PersonCar) {
                        strPerson += car.name + "  ";
                        allPerson += ((PersonCar) car).getPerson();//注意需要类型转换 ecli会自动帮你加上
                    } else if (car instanceof GoodsCar) {
                        strGoods += car.name + "  ";
                        allGoods += ((GoodsCar) car).getGoods();
                    } else if (car instanceof PickUpCar) {
                        strPerson += car.name + "  ";
                        strGoods += car.name + "  ";
                        allPerson += ((PickUpCar) car).getPerson();
                        allGoods += ((PickUpCar) car).getGoods();
                    }

                }
            }
        }
        System.out.println("您的账单如下：");
        System.out.println("可载人的车型有：");
        System.out.println(strPerson + "\t共可载人：" + allPerson + " 人");
        System.out.println("可载货的车型有：");
        System.out.println(strGoods + "\t共可载货：" + allGoods + " 吨");
        System.out.println("您租车的总价格为：" + allMoney * rentDay + " 元\n  感谢您的使用！");


    }


}

