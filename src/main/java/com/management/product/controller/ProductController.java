package com.management.product.controller;

import com.management.product.entity.Product;
import com.management.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * The class implements a set of methods for working with
 * objects of {@link Product} class or subclasses for admins.
 * Class methods create and return modelsAndView, depending on the request.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/admin/product")
@ComponentScan(basePackages = "com.management.product.service")
@SuppressWarnings("SpringMVCViewInspection")
public class ProductController {

    /**
     * The implementation of the interface describes a set of methods
     * for working with objects of the {@link Product} class.
     */
    private final ProductService productService;

    /**
     * Constructor.
     *
     * @param productService a implementation of the {@link ProductService} interface.
     */
    @Autowired
    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    /**
     * Returns the page to add a new product.
     * Request mapping: /admin/product/new
     * Method: GET
     *
     * @return The view name.
     */
    @RequestMapping(
            value = "/new",
            method = RequestMethod.GET
    )
    public String getNewProductPage() {
        return "add_product";
    }

    /**
     * Adds new product and redirects by URL /home.
     * Request mapping: /admin/product/add
     * Method: POST
     *
     * @param title        a title of the new product.
     * @param manufacturer a manufacturer of the new product.
     * @param description  a description of the new product.
     * @param cost         a cost of the new product.
     * @return The view name.
     */
    @RequestMapping(
            value = "/add",
            method = RequestMethod.POST
    )
    public String addNewProduct(
            @RequestParam(value = "title", defaultValue = "") final String title,
            @RequestParam(value = "manufacturer", defaultValue = "") final String manufacturer,
            @RequestParam(value = "description", defaultValue = "") final String description,
            @RequestParam(value = "cost", defaultValue = "0") final int cost
    ) {
        Product product = new Product(title, manufacturer, description, cost);
        this.productService.add(product);
        return "redirect:/home";
    }

    /**
     * Returns the page to edit the product with id.
     * Request mapping: /admin/product/edit/{product_id}
     * Method: GET
     *
     * @param id a id of the product to edit.
     * @return The ready object of class ModelAndView.
     */
    @RequestMapping(
            value = "/edit/{id}",
            method = RequestMethod.GET
    )
    public ModelAndView getPageForUpdatingProduct(@PathVariable("id") final long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", this.productService.get(id));
        modelAndView.setViewName("edit_product");
        return modelAndView;
    }

    /**
     * Updates and save the product with url
     * and redirects by URL /home.
     * Request mapping: /admin/product/update
     * Method: POST
     *
     * @param id           a id of the product to update.
     * @param title        a new title to the product.
     * @param manufacturer a new manufacturer to the product.
     * @param description  a new description to the product.
     * @param cost         a new cost to the product.
     * @return The view name.
     */
    @RequestMapping(
            value = "/update/{id}",
            method = RequestMethod.POST
    )
    public String updateProduct(
            @PathVariable("id") final long id,
            @RequestParam(value = "title", defaultValue = "") final String title,
            @RequestParam(value = "manufacturer", defaultValue = "") final String manufacturer,
            @RequestParam(value = "description", defaultValue = "") final String description,
            @RequestParam(value = "cost", defaultValue = "0") final int cost
    ) {
        Product product = this.productService.get(id);
        product.setTitle(title);
        product.setManufacturer(manufacturer);
        product.setDescription(description);
        product.setCost(cost);
        this.productService.update(product);
        return "redirect:/home";
    }

    /**
     * Removes product with id and redirects by URL /home.
     * Request mapping: /admin/product/delete/{product_id}
     * Method: GET
     *
     * @param id a id of the product to remove.
     * @return The view name.
     */
    @RequestMapping(
            value = "/delete/{id}",
            method = RequestMethod.GET
    )
    public String deleteProduct(@PathVariable("id") final long id) {
        this.productService.remove(id);
        return "redirect:/home";
    }
}
