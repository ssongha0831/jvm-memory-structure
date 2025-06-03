/*
송하연
이론 정리 : https://github.com/ssongha0831/jvm-memory-structure/edit/main/README.md
 */
package com.hayeon.jvm;

interface Coffee {
    String getCoffee();
    int getPrice();
}

class Americano implements Coffee {

    @Override
    public String getCoffee() {
        return "아메리카노";
    }

    @Override
    public int getPrice() {
        return 2000;
    }
}

abstract class CoffeeDecorator implements Coffee {
    private Coffee coffee;
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getCoffee () {
        return coffee.getCoffee();
    }

    @Override
    public int getPrice () {
        return coffee.getPrice();
    }
}

class ShotDecorator extends CoffeeDecorator {
    public ShotDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getCoffee () {
        return super.getCoffee() + " 샷 추가";
    }

    @Override
    public int getPrice () {
        return super.getPrice() + 500;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getCoffee () {
        return super.getCoffee() + " 설탕 추가";
    }

    @Override
    public int getPrice () {
        return super.getPrice() + 500;
    }
}

public class JavaStudy4_04 {
    public static void main(String[] args) {
        Coffee americano = new Americano();
        Coffee americanoShotAdd = new ShotDecorator(americano);
        Coffee americanoWithShotAndSugar = new SugarDecorator(americanoShotAdd); // 섵탕추가

        System.out.println("[주문내역] - " + americanoShotAdd.getCoffee());
        System.out.println("[총 가격] : " + americanoShotAdd.getPrice() + "원");

        System.out.println("[주문내역] - " + americanoWithShotAndSugar.getCoffee());
        System.out.println("[총 가격] : " + americanoWithShotAndSugar.getPrice() + "원");

    }
}
