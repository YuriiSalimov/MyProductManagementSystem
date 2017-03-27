package com.management.product.dao;

import com.management.product.entity.Product;
import com.management.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
@Repository
public final class ProductDaoImpl extends DataDaoImpl<Product> implements ProductDao {

    private final ProductRepository repository;

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
