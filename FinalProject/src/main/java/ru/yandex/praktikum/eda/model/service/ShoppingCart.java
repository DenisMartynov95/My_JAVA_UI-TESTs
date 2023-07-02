package ru.yandex.praktikum.eda.model.service;
import ru.yandex.praktikum.eda.model.Food;

public class ShoppingCart {

    private final Food[] foods;

    public ShoppingCart(Food[] foods) {
        this.foods = foods;
    }

    public double getTotalWithoutDiscount() {
        double total = 0.0;
        for (int i = 0; i < this.foods.length; i++) {
            total = total + this.foods[i].getPrice() * this.foods[i].getAmount();
        }
        return total;
    }


    public double getTotalWithDiscount() {
        double total = 0.0;
        for (int i = 0; i < this.foods.length; i++) {
            double current = this.foods[i].getPrice() * this.foods[i].getAmount();
            if (this.foods[i].getDiscount() > 0) {
                current = current - current * this.foods[i].getDiscount() / 100;
            }
            total = total + current;
        }
        return total;
    }

    public double getTotalVeggiesWithoutDiscount() {
        double total = 0.0;
        for (int i = 0; i < this.foods.length; i++) {
            if (this.foods[i].getIsVegetarian()) {
                total = total + this.foods[i].getPrice() * this.foods[i].getAmount();
            }
        }
        return total;
    }


}

