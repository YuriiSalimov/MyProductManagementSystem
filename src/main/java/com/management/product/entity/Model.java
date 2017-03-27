package com.management.product.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The abstract superclass class implements a set of standard methods
 * for working with entity of the {@link Model} class or subclasses.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
@MappedSuperclass
public abstract class Model implements Serializable {

    /**
     * It is used during deserialization to verify that
     * the sender and receiver of a serialized object have
     * loaded classes for that object that are compatible
     * with respect to serialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The unique identifier for each object.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Model{id=" + getId() + '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param object The reference object with which to compare.
     * @return Returns true if this object is the same as the obj
     * argument, otherwise returns false.
     */
    @Override
    public boolean equals(final Object object) {
        return (object != null) && (super.equals(object) || (getClass() == object.getClass()));
    }

    /**
     * Returns a unique identifier of the model.
     *
     * @return The unique identifier.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Sets new identifier to the model.
     *
     * @param id a new identifier to the model.
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * Returns a hash code value for the object.
     * This method is supported for the benefit
     * of hash tables such as those provided by HashMap.
     *
     * @return A hash code value for this object.
     */
    @Override
    public abstract int hashCode();
}
