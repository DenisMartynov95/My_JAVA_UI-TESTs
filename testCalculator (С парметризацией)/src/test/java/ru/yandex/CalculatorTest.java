package ru.yandex;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class) // означает, что тесты класса CalculatorTest будет запускать раннер Parameterized
public class CalculatorTest { // создали тестовый класс

    private final int firstNumber; //Чтобы написать параметризованный тест для этого метода, понадобится три параметра: firstNumber — первое число
    private final int secondNumber; // secondNumber — второе число, expected — ожидаемый результат, то есть сумма двух чисел.
    private final int expected; // создали поля тестового класса. Обрати внимание: все поля — final, потому что инициализируются один раз в конструкторе,
                                // и private, потому что доступны только в пределах класса.

    public CalculatorTest(int firstNumber, int secondNumber, int expected) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.expected = expected; // создали конструктор тестового класса
    }

    @Parameterized.Parameters //Чтобы получать конкретные тестовые значения,нужен метод с аннотацией @Parameterized.Parameters.Он должен быть публичным и статическим:
    public static Object[] getSumData() { //Метод getSumData() возвращает двумерный массив Object, то есть массив, в котором хранятся другие массивы
        return new Object[][] {
                { 1, 9, 10}, //Каждая строка с данными — это тестовый набор для одного запуска теста: firstNumber, secondNumber, expected.
                             // Первый раз тест будет запущен со значениями 1, 9, 10
                { 1, 0, 1}, // А второй — со значениями 1, 0, 1. Количество запусков теста равно количеству строк с данными.
        };
    }

    @Test
    public void shouldBeSum() {
        Calculator calculator = new Calculator();
        int actual = calculator.sum(firstNumber, secondNumber); // обратились к полям тестового класса
        assertEquals(expected, actual); // сравнили ожидаемый и фактический результат
    }
}
