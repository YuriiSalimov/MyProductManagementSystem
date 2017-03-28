package com.management.product.dao;

import com.management.product.entity.Product;

/**
 * The interface provides a set of standard methods
 * for working {@link Product} objects with a database.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public interface ProductDao extends DataDao<Product> {

    /**
     * Returns product with the parameter title from a database.
     *
     * @param title a title of the user to return.
     * @return The user with parameter name.
     */
    Product getByTitle(String title);

    /**
     * Removes product with the parameter title from a database.
     *
     * @param title a title of the user to remove.
     */
    void removeByTitle(String title);
}
