package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;

public class ProductRepositoryTest {

    Product item1 = new Book(1, "Название_1", 100, "Автор_1");
    Product item2 = new Book(2, "Название_2", 200, "Автор_2");
    Product item3 = new Book(3, "Название_3", 300, "Автор_3");
    Product item4 = new Smartphone(4, "Название_4", 10_000, "Производитель_4");
    Product item5 = new Smartphone(5, "Название_5", 20_000, "Производитель_5");

    @Test
    public void shouldRemoveExistingItemFromArray() {
        ProductRepository repository = new ProductRepository();
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.removeById(3);

        Product[] expected = {item1, item2};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNonExistingItemToArray() {
        ProductRepository repository = new ProductRepository();
        repository.save(item1);
        repository.save(item2);
        repository.save(item5);

        Product[] expected = {item1, item2, item5};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}