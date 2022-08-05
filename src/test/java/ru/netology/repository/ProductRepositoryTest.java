package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();

    Product product1 = new Book(1, "Гордость и предубеждение", 300, "Джейн_Остин");
    Product product2 = new Book(22, "1984", 300, "Джордж Оруэлл");
    Product product3 = new Book(333, "Жизнь и удача", 450, "Орлов");
    Product product4 = new Book(44, "Жизнь и работа", 460, "Орлов");
    Product product5 = new Smartphone(5, "iPhone 13", 100_000, "Apple");
    Product product6 = new Smartphone(66, "Galaxy S22", 30_000, "Samsung");
    Product product7 = new Smartphone(777, "Xiaomi 11", 25_000, "Xiaomi");
    Product product8 = new Smartphone(88, "Xiaomi 11 Pro", 30_000, "Xiaomi");

    @Test
    public void findEmpty() {
        Product[] expected = {};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void AddOnlyBooks() {
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void AddOnlySmartphone() {
        repository.add(product5);
        repository.add(product6);
        repository.add(product7);
        repository.add(product8);
        Product[] expected = {product5, product6, product7, product8};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    public void removeExistingProductFromArray() {
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        repository.remove(333);
        Product[] expected = {product1, product2, product4};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNotExistingProductFromArray() {
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        assertThrows(RuntimeException.class, () -> {
            repository.remove(9);
        });
    }

    @Test
    public void shouldSave() {
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        repository.add(product8);
        Product[] expected = {product1, product2, product3, product4, product8};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}