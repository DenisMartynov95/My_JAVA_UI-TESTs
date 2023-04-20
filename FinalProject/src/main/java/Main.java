import ru.yandex.praktikum.eda.model.Apple;
import ru.yandex.praktikum.eda.model.Food;
import ru.yandex.praktikum.eda.model.Meat;
import ru.yandex.praktikum.eda.model.constants.Colour;
import ru.yandex.praktikum.eda.model.service.ShoppingCart;

public class Main {
    public static void main(String[] args) {
        Meat meat = new Meat(5 ,100);
        Apple appleRed = new Apple(10, 50, Colour.RED);
        Apple appleGreen = new Apple(8, 60, Colour.GREEN);

        Food[] foods = {meat, appleRed, appleGreen};

        ShoppingCart cart = new ShoppingCart(foods);

        System.out.println(cart.getTotalWithoutDiscount());
        System.out.println(cart.getTotalWithDiscount());
        System.out.println(cart.getTotalVeggiesWithoutDiscount());
    }
}
