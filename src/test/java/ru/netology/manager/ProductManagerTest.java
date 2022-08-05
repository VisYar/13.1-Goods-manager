package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product product1 = new Book(1, "Гордость и предубеждение", 300, "Джейн_Остин");
    Product product2 = new Book(22, "1984", 300, "Джордж Оруэлл");
    Product product3 = new Book(333, "Жизнь и удача", 450, "Орлов");
    Product product4 = new Book(44, "Жизнь и работа", 460, "Орлов");
    Product product5 = new Smartphone(5, "iPhone 13", 100_000, "Apple");
    Product product6 = new Smartphone(66, "Galaxy S22", 30_000, "Samsung");
    Product product7 = new Smartphone(777, "Xiaomi 11", 25_000, "Xiaomi");
    Product product8 = new Smartphone(88, "Xiaomi 11 Pro", 30_000, "Xiaomi");

    @BeforeEach
    public void before() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
        manager.add(product7);
        manager.add(product8);
    }

    @Test
    public void findBookByName() {
        Product[] expected = new Product[]{product2};
        Product[] actual = manager.searchBy("1984");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findNonExistentBookByName() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Война и мир");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findMultipleBooksByName() {
        Product[] expected = {product3, product4};
        Product[] actual = manager.searchBy("Жизнь");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findSmartphoneByName() {
        Product[] expected = new Product[]{product6};
        Product[] actual = manager.searchBy("Galaxy");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findNonExistentSmartphoneByName() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Oppo");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findMultipleSmartphonesByName() {
        Product[] expected = {product7, product8};
        Product[] actual = manager.searchBy("Xiaomi 11");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBookByName() {
        boolean expected = true;
        boolean actual = manager.matches(product2, "1984");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindBookByAuthor() {
        boolean expected = false;
        boolean actual = manager.matches(product3, "Орлов");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByName() {
        boolean expected = true;
        boolean actual = manager.matches(product8, "Xiaomi 11 Pro");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByManufacture() {
        boolean expected = false;
        boolean actual = manager.matches(product5, "Apple");
        assertEquals(expected, actual);
    }
}
