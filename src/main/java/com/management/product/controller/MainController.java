package com.management.product.controller;

import com.management.product.entity.Product;
import com.management.product.entity.User;
import com.management.product.service.ProductService;
import com.management.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * The class implements a set of methods for working
 * with main ModelAndView object. Class methods create and return modelsAndView,
 * depending on the request.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
@Controller
@ComponentScan(basePackages = "com.management.product.service")
public class MainController {

    /**
     * The implementation of the interface describes a set of methods
     * for working with objects of the {@link Product} class.
     */
    private final ProductService productService;

    /**
     * The implementation of the interface describes a set of methods
     * for working with objects of the {@link User} class.
     */
    private final UserService userService;

    /**
     * Constructor.
     * Initializes a implementation of the service layer interface.
     *
     * @param productService a implementation of the {@link ProductService} interface.
     * @param userService    a implementation of the {@link UserService} interface.
     */
    @Autowired
    public MainController(
            final ProductService productService,
            final UserService userService
    ) {
        this.productService = productService;
        this.userService = userService;
    }

    /**
     * Returns modelAndView with all products.
     * Request mapping: '', /, /index, /home
     * Method: GET
     *
     * @return The ready object of class ModelAndView.
     */
    @RequestMapping(
            value = { "", "/", "/index", "/home" },
            method = RequestMethod.GET
    )
    public ModelAndView getIndexPage() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", this.productService.getAll());
        modelAndView.addObject("is_admin", this.userService.isAuthenticatedAdmin());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * Returns modelAndView with all users.
     * Request mapping: '/users
     * Method: GET
     *
     * @return The ready object of class ModelAndView.
     */
    @RequestMapping(
            value = "/users",
            method = RequestMethod.GET
    )
    public ModelAndView getUsersPage() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", this.userService.getAll());
        modelAndView.addObject("is_admin", this.userService.isAuthenticatedAdmin());
        modelAndView.setViewName("users");
        return modelAndView;
    }

    /**
     * Returns modelAndView with one product.
     * Request mapping: '/product/{product_id}
     * Method: GET
     *
     * @param id a id of the product to return.
     * @return The ready object of class ModelAndView.
     */
    @RequestMapping(
            value = "/product/{id}",
            method = RequestMethod.GET
    )
    public ModelAndView getProductPage(@PathVariable("id") final long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", this.productService.get(id));
        modelAndView.addObject("is_admin", this.userService.isAuthenticatedAdmin());
        modelAndView.setViewName("product");
        return modelAndView;
    }
}
