package ru.yandex;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void shouldSumPositive() {
        Calculator calculator = new Calculator(); // создали экземпляр класса
        int firstNumber = 1;
        int secondNumber = 9;
        int actual = calculator.sum(firstNumber, secondNumber); // вызвали проверяемый метод
        int expected = 10;
        assertEquals(expected, actual); // сравнили ожидаемый результат с фактическим
    }

    @Test //Второй тест
    public void shouldSumPositiveAndZero() {
        Calculator calculator = new Calculator(); // создали экземпляр класса
        int firstNumber = 1;
        int secondNumber = 0;
        int actual = calculator.sum(firstNumber, secondNumber); // вызвали проверяемый метод
        int expected = 1;
        assertEquals(expected, actual); // сравнили ожидаемый результат с фактическим
    }

}
