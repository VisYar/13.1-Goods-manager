package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.Smartphone;

public class SmartphoneTest {

    @Test
    public void shouldFindItemByNameOfSmartphone() {
        Smartphone smartphone = new Smartphone(4, "Название_4", 10_000, "Производитель_4");

        boolean expected = true;
        boolean actual = smartphone.matches(smartphone, "Название_4");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindItemByManufacturer() {
        Smartphone smartphone = new Smartphone(5, "Название_5", 20_000, "Производитель_5");

        boolean expected = true;
        boolean actual = smartphone.matches(smartphone, "Производитель_5");

        Assertions.assertEquals(expected, actual);
    }
}