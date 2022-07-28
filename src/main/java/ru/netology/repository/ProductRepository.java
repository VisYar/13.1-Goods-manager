package ru.netology.repository;

import ru.netology.product.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

//    public void save(Product item) {
//        Product[] tmp = new Product[items.length + 1];
//        System.arraycopy(items, 0, tmp, 0, items.length);
//        tmp[tmp.length - 1] = item;
//        items = tmp;
//    }

    public Product[] findAll() {
        return items;
    }

    public void removeById(int id) {
        Product draft_1 = findById(id);
        if (draft_1 == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Product[] tmp = new Product[items.length - 1];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public void addNewProducts(Product addedProduct) {
        Product draft_2 = findById(addedProduct.getId());
        if (draft_2 != null) {
            throw new AlreadyExistsException("Element with id: " + addedProduct.getId() + " already exists");
        }
        Product[]tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = addedProduct;
        items = tmp;
    }

    public Product findById(int id){
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Product[] getSave() {
        return items;
    }
}