package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();

    Product item1 = new Book(1, "Название_1", 100, "Автор_1");
    Product item2 = new Book(2, "Название_2", 200, "Автор_2");
    Product item3 = new Book(3, "Название_3", 300, "Автор_3");
    Product item4 = new Smartphone(4, "Название_4", 10_000, "Производитель_4");
    Product item5 = new Smartphone(5, "Название_5", 20_000, "Производитель_5");

    @Test
    public void successOfDeletingExistingItem() {

        repository.addNewProducts(item1);
        repository.addNewProducts(item2);
        repository.addNewProducts(item3);
        repository.addNewProducts(item4);
        repository.addNewProducts(item5);
        repository.removeById(3);

        Product[] expected = {item1, item2, item4, item5};
        Product[] actual = repository.getSave();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void tryToRemoveNonExistentItem() {

        repository.addNewProducts(item1);
        repository.addNewProducts(item2);
        repository.addNewProducts(item3);
        repository.addNewProducts(item4);
        repository.addNewProducts(item5);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(7);
        });
    }

    @Test
    public void successOfDeletingExistingItem2() {

        repository.addNewProducts(item1);
        repository.addNewProducts(item2);
        repository.addNewProducts(item3);
        repository.addNewProducts(item4);
        repository.addNewProducts(item5);

        Product[] expected = {item1, item2, item3, item4, item5};
        Product[] actual = repository.getSave();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void tryAddItemWithDuplicateId() {

        repository.addNewProducts(item1);
        repository.addNewProducts(item2);
        repository.addNewProducts(item3);
        repository.addNewProducts(item4);
        repository.addNewProducts(item5);

        assertThrows(AlreadyExistsException.class, () -> {
            repository.addNewProducts(item3);
        });
    }
}