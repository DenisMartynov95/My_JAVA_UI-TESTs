package ru.yandex.praktikum.eda.model;

import ru.yandex.praktikum.eda.model.constants.Colour;
import ru.yandex.praktikum.eda.model.constants.Discount;

public class Apple extends Food { //Здесь тоже создается вторичный класс наследуемый от Food
    private String colour; //У данного класса существует уникальная переменная Цвет
    public Apple(int amount, double price, String colour) { //Создается конструктор, где перечисляются все переменные
        // который в том числе и были унаследованы от класса Food

        super(amount, price, true); //Затем данные переменные связываются, а одной из-них присваивают true
        this.colour = colour; // отдельно связывается уникальная переменная
    }

    @Override
    public int getDiscount() { //Метод, унаследованный от класса Food перезаписывается, так как есть условие на скидку
        if (this.colour == Colour.RED) {  //Которое зависит от цвета яблока
            return Discount.DISCOUNT; //Тут как раз показано, если яблоко красное, то присваивается скидка
        } else {
            return 0; //Если не красное - то скидки нет.
        }
    }
}
