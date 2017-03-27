package com.management.product.service;

import com.management.product.dao.ProductDao;
import com.management.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Service
@ComponentScan(basePackages = "com.management.product.dao")
public final class ProductServiceImpl extends DataServiceImpl<Product> implements ProductService {

    private final ProductDao dao;

    @Autowired
    public ProductServiceImpl(final ProductDao dao) {
        super(dao);
        this.dao = dao;
    }

    /**
     * Returns product with the parameter title.
     *
     * @param title a title of the product to return.
     * @return The product with the parameter title.
     * @throws IllegalArgumentException Throw exception when parameter title is blank.
     * @throws NullPointerException     Throws exception if product is absent.
     */
    @Override
    @Transactional(readOnly = true)
    public Product getByTitle(String title)
            throws IllegalArgumentException, NullPointerException {
        if (isBlank(title)) {
            throw new IllegalArgumentException("Input title is blank!");
        }
        final Product product = this.dao.getByTitle(title);
        if (product == null) {
            throw new NullPointerException("Can`t find product by title \"" + title + "\"!");
        }
        return product;
    }

    /**
     * Removes product with the parameter title.
     * Removes product if title is not blank.
     *
     * @param title a title of the product to remove.
     */
    @Override
    @Transactional
    public void removeByTitle(String title) {
        if (isNotBlank(title)) {
            this.dao.removeByTitle(title);
        }
    }

    /**
     * Return Class object of {@link Product} class.
     *
     * @return The Class object of {@link Product} class.
     */
    @Override
    protected Class<Product> getModelClass() {
        return Product.class;
    }
}
