package com.management.product.repository;

import com.management.product.entity.Product;

/**
 * The interface provides a set of JPA methods
 * for working {@link Product} objects with a database.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public interface ProductRepository extends DataRepository<Product> {

    /**
     * Returns product from a database,
     * which matches the parameter name.
     *
     * @param title a name of the product to return.
     * @return The object of class {@link Product}.
     */
    Product findByTitle(String title);

    /**
     * Removes product from a database,
     * which matches the parameter name.
     *
     * @param title a name of the product to remove.
     */
    void deleteByTitle(String title);
}
