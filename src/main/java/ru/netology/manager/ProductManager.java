package ru.netology.manager;

import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;
import ru.netology.repository.ProductRepository;


public class ProductManager {
    private final ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    private Product[] items = new Product[0];

    public void add(Product item) {
        Product[] tmp = new Product[items.length + 1];
        System.arraycopy(items, 0, tmp, 0, items.length);
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {

        if (product.getName().contains(search)) {
            return true;
        }
        if (product instanceof Book) {
            if (((Book) product).getAuthor().contains(search)) {
                return true;
            }
        }
        if (product instanceof Smartphone) {
            return ((Smartphone) product).getManufacturer().contains(search);
        }
        return false;
    }
}