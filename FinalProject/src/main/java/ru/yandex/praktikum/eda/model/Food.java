package ru.yandex.praktikum.eda.model;

public abstract class Food implements Discountable {  // Создается абстрактный класс который служит родителем для классов
                                                      // Meat и Apple, а так же он наследует метод из интерфейса Discountable

    protected int amount;   //Создаются переменные (поля) у класса
    protected double price;
    protected boolean isVegetarian;

    public Food(int amount, double price, boolean isVegetarian) { //Создается конструктор класса
        this.amount = amount;  //Где связываются поля конструктора с полями класса
        this.price = price;
        this.isVegetarian = isVegetarian;
    }

    @Override
    public int getDiscount() { //
        return 0;
    }

    public double getPrice() { //
        return this.price;
    }

    public int getAmount() { //
        return this.amount;
    }

    public boolean getIsVegetarian() { //
        return this.isVegetarian;
    }
}
