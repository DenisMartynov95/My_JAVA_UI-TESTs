package ru.yandex.praktikum.eda.model;

public class Meat extends Food {  //Создан вторичный класс который наследуется от абстрактного Food и перенимает все поля и методы
    public Meat(int amount, double price) { //Создается конструктор для этого класса с уникальным продуктом Meat
        super(amount, price, false); //Здесь же связываются эти значения от Food и конструктора
    }
}
