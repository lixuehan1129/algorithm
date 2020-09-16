package com.offer.Design.factory.test;

public interface Shop {
    Fruit saleFruit();
}

class AppleShop implements Shop{

    @Override
    public Fruit saleFruit() {
        System.out.println("卖苹果");
        return new Apple();
    }
}

class MellonShop implements Shop{

    @Override
    public Fruit saleFruit() {
        System.out.println("卖西瓜");
        return new Mellon();
    }
}
