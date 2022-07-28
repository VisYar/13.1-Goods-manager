package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.ProductRepository;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)

public class ProductManagerTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    ProductManager manager;

    Product first = new Book(1, "Название_1", 100, "Автор_1");
    Product second = new Book(2, "Название_2", 200, "Автор_2");
    Product third = new Smartphone(4, "Название_4", 10_000, "Производитель_4");
    Product fourth = new Smartphone(5, "Название_5", 20_000, "Производитель_4");

    @BeforeEach
    public void SetUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    void shouldSearchByBookName() {
        Product[] returned = new Product[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Название_2");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookAuthor() {
        Product[] returned = new Product[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Автор_1");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneName() {
        Product[] returned = new Product[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("Название_5");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneManufacturer() {
        Product[] returned = new Product[]{first, second, third, fourth};
        doReturn(returned).when(repository).findAll();
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Производитель_4");
        assertArrayEquals(expected, actual);
    }
}
