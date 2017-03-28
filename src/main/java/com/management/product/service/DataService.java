package com.management.product.service;

import com.management.product.entity.Model;

import java.util.Collection;

/**
 * The interface of the service layer, describes a set of methods
 * for working with objects of {@link Model} class or subclasses.
 *
 * @param <T> Entity type, extends {@link Model}.
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public interface DataService<T extends Model> {

    /**
     * Saves and returns model object of {@link Model} class or subclasses.
     *
     * @param model the model to add.
     * @return The saving model.
     */
    T add(T model);

    /**
     * Saves and returns objects of {@link Model} class or subclasses.
     *
     * @param models the models to add.
     * @return The saving models.
     */
    Collection<T> addAll(Collection<T> models);

    /**
     * Updates and returns object of {@link Model} class or subclasses.
     *
     * @param model a model to update.
     * @return The updating models.
     */
    T update(T model);

    /**
     * Updates and returns objects of {@link Model} class or subclasses.
     *
     * @param models the models to update.
     * @return The updating models.
     */
    Collection<T> update(Collection<T> models);

    /**
     * Returns object of {@link Model} class or subclasses with parameter id.
     *
     * @param id is id of object to return.
     * @return The object models with parameter id.
     */
    T get(long id);

    /**
     * Returns all valid objects of {@link Model} class or subclasses.
     *
     * @return The all valid models.
     */
    Collection<T> getAll();

    /**
     * Removes object of {@link Model} class or subclasses with parameter id.
     *
     * @param id a id of the model to remove.
     */
    void remove(long id);

    /**
     * Removes object of {@link Model} class or subclasses.
     *
     * @param model the model to remove.
     */
    void remove(T model);

    /**
     * Removes objects of {@link Model} class or subclasses.
     *
     * @param models the models to remove.
     */
    void remove(Collection<T> models);

    /**
     * Removes all objects of {@link Model} class or subclasses.
     */
    void removeAll();

    /**
     * Checks whether the object of {@link Model} class or subclasses
     * is exists with parameter id.
     *
     * @param id a id of the model to exist.
     * @return Returns {@code true} if model is exists,
     * otherwise returns {@code false}.
     */
    boolean exists(long id);

    /**
     * Checks whether the object of {@link Model} class
     * or subclasses is exists.
     *
     * @param model the model to exists.
     * @return Returns {@code true} if model is exists,
     * otherwise returns {@code false}.
     */
    boolean exists(T model);
}
