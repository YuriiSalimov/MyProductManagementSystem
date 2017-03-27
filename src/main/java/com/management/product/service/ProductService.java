package com.management.product.service;

import com.management.product.entity.Product;

/**
 * The interface of the service layer, describes a set of methods
 * for working with objects of the class {@link Product}.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public interface ProductService extends DataService<Product> {

    /**
     * Returns product which the parameter title.
     *
     * @param title a username of the product to return.
     * @return The product which the parameter username.
     */
    Product getByTitle(String title);

    /**
     * Removes product with the parameter username.
     *
     * @param title a title of the product to remove.
     */
    void removeByTitle(String title);
}
