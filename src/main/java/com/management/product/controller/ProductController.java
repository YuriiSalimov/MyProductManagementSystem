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
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/admin/product")
@ComponentScan(basePackages = "com.management.product.service")
@SuppressWarnings("SpringMVCViewInspection")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(
            value = "/new",
            method = RequestMethod.GET
    )
    public String getNewProductPage() {
        return "add_product";
    }

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

    @RequestMapping(
            value = "/delete/{id}",
            method = RequestMethod.GET
    )
    public String deleteProduct(@PathVariable("id") final long id) {
        this.productService.remove(id);
        return "redirect:/home";
    }
}
