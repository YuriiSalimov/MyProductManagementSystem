package com.management.product.controller;

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
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
@Controller
@ComponentScan(basePackages = "com.management.product.service")
@SuppressWarnings("SpringMVCViewInspection")
public class MainController {

    private final ProductService productService;
    private final UserService userService;

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
            value = {"", "/", "/index", "/home"},
            method = RequestMethod.GET
    )
    public ModelAndView getIndexPage() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products", this.productService.getAll());
        modelAndView.addObject("users", this.userService.getAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(
            value = "/product/{id}",
            method = RequestMethod.GET
    )
    public ModelAndView getProductPage(@PathVariable("id") final long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", this.productService.get(id));
        modelAndView.setViewName("one_product");
        return modelAndView;
    }
}
