package com.management.product.dao;

import com.management.product.entity.Product;
import com.management.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * The class implements a set of standard methods for working {@link Product}
 * objects with a database.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
@Repository
public class ProductDaoImpl extends DataDaoImpl<Product> implements ProductDao {

    /**
     * The interface provides a set of JPA methods
     * for working {@link Product} objects with a database.
     */
    private final ProductRepository repository;

    /**
     * Constructor.
     *
     * @param repository a implementation of the interface provides a set of JPA methods
     *                   for working {@link Product} objects with a database.
     */
    @Autowired
    public ProductDaoImpl(final ProductRepository repository) {
        super(repository);
        this.repository = repository;
    }

    /**
     * Returns product with the parameter title from a database.
     *
     * @param title a title of the user to return.
     * @return The user with parameter name.
     */
    @Override
    public Product getByTitle(String title) {
        return this.repository.findByTitle(title);
    }

    /**
     * Removes product with the parameter title from a database.
     *
     * @param title a title of the user to remove.
     */
    @Override
    public void removeByTitle(String title) {
        this.repository.deleteByTitle(title);
    }
}
