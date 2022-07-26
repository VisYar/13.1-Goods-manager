package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;

public class BookTest {

    @Test
    public void shouldFindItemByName() {
        Book book = new Book(1, "Название_1", 100, "Автор_1");

        boolean expected = true;
        boolean actual = book.matches(book, "Название_1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindItemByAuthor() {
        Book book = new Book(3, "Название_3", 200, "Автор_3");

        boolean expected = true;
        boolean actual = book.matches(book, "Автор_3");

        Assertions.assertEquals(expected, actual);
    }
}