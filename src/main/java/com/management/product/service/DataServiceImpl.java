package com.management.product.service;

import com.management.product.entity.Model;
import com.management.product.repository.DataRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * The class of the service layer, describes a set of methods
 * for working with objects of {@link Model} class or subclasses.
 *
 * @param <T> entity type, extends {@link Model}.
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public abstract class DataServiceImpl<T extends Model> implements DataService<T> {

    /**
     * The object provides a set of standard JPA methods
     * for working {@link Model} objects with the database.
     */
    private final DataRepository<T> repository;

    /**
     * Constructor.
     * Initializes a implementations of the interfaces.
     *
     * @param repository a implementation of the {@link DataRepository} interface.
     */
    DataServiceImpl(final DataRepository<T> repository) {
        this.repository = repository;
    }

    /**
     * Saves and returns object of {@link Model} class or subclasses.
     * Returns input object if model is not valid.
     *
     * @param model the model to add.
     * @return The saving model or input object.
     * throws IllegalArgumentException Throw exception when input model is {@code null}.
     */
    @Override
    @Transactional
    public T add(final T model) throws IllegalArgumentException {
        if (model == null) {
            throw new IllegalArgumentException("Input model is null!");
        }
        return this.repository.save(model);
    }

    /**
     * Saves and returns objects of {@link Model} class or subclasses.
     * Returns empty collection if models is empty.
     *
     * @param models the models to add.
     * @return The saving models or empty collection.
     */
    @Override
    @Transactional
    public Collection<T> addAll(final Collection<T> models) {
        if ((models == null) || (models.isEmpty())) {
            throw new IllegalArgumentException("Input model is null!");
        }
        return this.repository.save(models);
    }

    /**
     * Updates and returns object of {@link Model} class or subclasses.
     * Return {@code null} if model is not valid.
     *
     * @param model the model to update.
     * @return The updating models or {@code null}.
     * throws IllegalArgumentException Throw exception when input model is {@code null}.
     */
    @Override
    @Transactional
    public T update(final T model) {
        return add(model);
    }

    /**
     * Updates and returns objects of {@link Model} class or subclasses.
     * Return empty collection if models is empty.
     *
     * @param models the models to update.
     * @return The updating models or empty collection if models is empty.
     */
    @Override
    @Transactional
    public Collection<T> update(final Collection<T> models) {
        return addAll(models);
    }

    /**
     * Returns object of class {@link Model} or subclasses with parameter id.
     * If id is {@code null} then throws NullPointerException.
     *
     * @param id is id of object to return.
     * @return The model with parameter id.
     * @throws NullPointerException Throw exception when object with parameter id is not exist.
     */
    @Override
    @Transactional(readOnly = true)
    public T get(final long id) throws NullPointerException {
        final T model = this.repository.findOne(id);
        if (model == null) {
            throw new NullPointerException(
                    "Can`t find " + getClassSimpleName() +
                            " by id " + id + "!"
            );
        }
        return model;
    }

    /**
     * Returns all valid objects of {@link Model} class or subclasses.
     *
     * @return The all models.
     */
    @Override
    @Transactional
    public Collection<T> getAll() {
        return this.repository.findAll();
    }

    /**
     * Removes object of {@link Model} class or subclasses
     * with parameter id.
     *
     * @param id a id of model to remove.
     */
    @Override
    @Transactional
    public void remove(final long id) {
        this.repository.delete(id);
    }

    /**
     * Removes object of {@link Model} class or subclasses.
     * Removes model if it is not {@code null}.
     *
     * @param model the model to remove.
     */
    @Override
    @Transactional
    public void remove(final T model) {
        if (model != null) {
            this.repository.delete(model);
        }
    }

    /**
     * Removes objects of {@link Model} class or subclasses.
     * Removes models if are not {@code null}.
     *
     * @param models the models to remove.
     */
    @Override
    @Transactional
    public void remove(final Collection<T> models) {
        if (models != null && !models.isEmpty()) {
            this.repository.delete(models);
        }
    }

    /**
     * Removes all objects of {@link Model} class or subclasses.
     */
    @Override
    @Transactional
    public void removeAll() {
        this.repository.deleteAll();
    }

    /**
     * Checks whether the object of {@link Model} class or subclasses
     * with parameter id is exists.
     *
     * @param id a id of the model to exists.
     * @return Returns {@code true} if the model is exists,
     * otherwise returns {@code false}.
     */
    @Override
    @Transactional(readOnly = true)
    public boolean exists(long id) {
        return this.repository.exists(id);
    }

    /**
     * Checks whether the object of {@link Model} class or subclasses is exists.
     * If model is {@code null} or model id is {@code null} then return {@code false}.
     *
     * @param model the models to exists.
     * @return Returns {@code true} if the model is exists,
     * otherwise returns {@code false}.
     */
    @Override
    @Transactional(readOnly = true)
    public boolean exists(final T model) {
        return (model != null) && exists(model.getId());
    }

    /**
     * Return name of {@link Model} class or subclasses.
     *
     * @return The name of {@link Model} class or subclasses.
     */
    protected String getClassName() {
        return getModelClass().getName();
    }

    /**
     * Return simple name of {@link Model} class or subclasses.
     *
     * @return The simple name of {@link Model} class or subclasses.
     */
    protected String getClassSimpleName() {
        return getModelClass().getSimpleName();
    }

    /**
     * Return Class object of {@link Model} or subclasses.
     *
     * @return The Class object of {@link Model} or subclasses.
     */
    protected abstract Class<T> getModelClass();
}
