package com.management.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * The class implements a set of standard methods for working
 * with entity of the {@link Product} class.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
@Entity
@Table(name = "products")
public class Product extends Model {

    /**
     * It is used during deserialization to verify that
     * the sender and receiver of a serialized object have
     * loaded classes for that object that are compatible
     * with respect to serialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The title of a product.
     */
    @Column(name = "title", nullable = false)
    private String title;

    /**
     * The manufacturer of a product.
     */
    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    /**
     * The description of a product.
     */
    @Column(name = "description", nullable = false)
    private String description;

    /**
     * The cost of a product.
     */
    @Column(name = "cost", nullable = false)
    private int cost;

    /**
     * Default constructor.
     */
    public Product() {
        this.title = "";
        this.manufacturer = "";
        this.description = "";
    }

    /**
     * Constructor.
     *
     * @param title a title of the new product.
     * @param cost  a cost of the new product.
     */
    public Product(String title, int cost) {
        this();
        setTitle(title);
        setCost(cost);
    }

    /**
     * Constructor.
     *
     * @param title        a title of the new product.
     * @param manufacturer a manufacturer of the new product.
     * @param cost         a cost of the new product.
     */
    public Product(String title, String manufacturer, int cost) {
        this(title, cost);
        setManufacturer(manufacturer);
    }

    /**
     * Constructor.
     *
     * @param title        a title of the new product.
     * @param manufacturer a manufacturer of the new product.
     * @param description  a description of the new product.
     * @param cost         a cost of the new product.
     */
    public Product(String title, String manufacturer, String description, int cost) {
        this(title, manufacturer, cost);
        setDescription(description);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Product{" + super.toString() +
                ", title='" + this.title + '\'' +
                ", manufacturer='" + this.manufacturer + '\'' +
                ", description='" + this.description + '\'' +
                ", cost=" + this.cost +
                '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param object The reference object with which to compare.
     * @return Returns true if this object is the same as the obj
     * argument, otherwise returns false.
     */
    @Override
    public boolean equals(Object object) {
        boolean result = super.equals(object);
        if (result) {
            Product other = (Product) object;
            result = this.title.equals(other.title) &&
                    this.manufacturer.equals(other.manufacturer) &&
                    this.description.equals(other.description) &&
                    (this.cost != other.cost);
        }
        return result;
    }

    /**
     * Returns a hash code value for the object.
     * This method is supported for the benefit
     * of hash tables such as those provided by HashMap.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        int result = this.title.hashCode();
        result = 31 * result + this.manufacturer.hashCode();
        result = 31 * result + this.description.hashCode();
        result = 31 * result + this.cost;
        return result;
    }

    /**
     * Returns the product title.
     *
     * @return the title or the empty string (never {@code null}).
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets a new title to the product.
     * If parameter title is blank, then sets empty string.
     *
     * @param title a new title to the product.
     */
    public void setTitle(String title) {
        this.title = isNotBlank(title) ? title : "";
    }

    /**
     * Returns the product manufacturer.
     *
     * @return the manufacturer or the empty string (never {@code null}).
     */
    public String getManufacturer() {
        return this.manufacturer;
    }

    /**
     * Sets a new manufacturer to the product.
     * If parameter manufacturer is blank, then sets empty string.
     *
     * @param manufacturer a new manufacturer to the product.
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = isNotBlank(manufacturer) ? manufacturer : "";
    }

    /**
     * Returns the product description.
     *
     * @return the description or the empty string (never {@code null}).
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets a new description to the product.
     * If parameter description is blank, then sets empty string.
     *
     * @param description a new description to the product.
     */
    public void setDescription(String description) {
        this.description = isNotBlank(description) ? description : "";
    }

    /**
     * Returns the product description.
     *
     * @return the product cost.
     */
    public int getCost() {
        return this.cost;
    }

    /**
     * Sets a new cost to the product.
     * If parameter cost is less than zero, then sets zero.
     *
     * @param cost a new cost to the product.
     */
    public void setCost(int cost) {
        this.cost = (cost > 0) ? cost : 0;
    }
}
