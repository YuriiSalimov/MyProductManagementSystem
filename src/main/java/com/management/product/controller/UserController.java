package com.management.product.controller;

import com.management.product.entity.User;
import com.management.product.enums.UserRole;
import com.management.product.service.UserService;
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
 * objects of {@link User} class or subclasses for admins.
 * Class methods create and return modelsAndView, depending on the request.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/admin/user")
@ComponentScan(basePackages = "com.management.product.service")
@SuppressWarnings("SpringMVCViewInspection")
public class UserController {

    /**
     * The implementation of the interface describes a set of methods
     * for working with objects of the {@link User} class.
     */
    private final UserService userService;

    /**
     * Constructor.
     *
     * @param userService a implementation of the {@link UserService} interface.
     */
    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the page to add a new user.
     * Request mapping: /admin/user/new
     * Method: GET
     *
     * @return The ready object of class ModelAndView.
     */
    @RequestMapping(
            value = "/new",
            method = RequestMethod.GET
    )
    public ModelAndView getNewUserPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roles", UserRole.values());
        modelAndView.setViewName("add_user");
        return modelAndView;
    }

    /**
     * Adds new user and redirects by URL /home.
     * Request mapping: /admin/user/add
     * Method: POST
     *
     * @param username a name of the new user.
     * @param password a password of the new user.
     * @param role     a role of the new user.
     * @param locked   a locked of the new user.
     * @return The view name.
     */
    @RequestMapping(
            value = "/add",
            method = RequestMethod.POST
    )
    public String addNewUser(
            @RequestParam(value = "username", defaultValue = "") final String username,
            @RequestParam(value = "password", defaultValue = "") final String password,
            @RequestParam(value = "role", defaultValue = "CLIENT") final UserRole role,
            @RequestParam(value = "locked", defaultValue = "false") final boolean locked
    ) {
        User user = new User(username, password, role);
        user.setLocked(locked);
        this.userService.add(user);
        return "redirect:/home";
    }

    /**
     * Returns the page to edit the user with id.
     * Request mapping: /admin/user/edit/{user_id}
     * Method: GET
     *
     * @param id a id of the user to edit.
     * @return The ready object of class ModelAndView.
     */
    @RequestMapping(
            value = "/edit/{id}",
            method = RequestMethod.GET
    )
    public ModelAndView getPageForUpdatingUser(@PathVariable("id") final long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", this.userService.get(id));
        modelAndView.addObject("roles", UserRole.values());
        modelAndView.setViewName("edit_user");
        return modelAndView;
    }

    /**
     * Updates and save the product with url
     * and redirects by URL /home.
     * Request mapping: /admin/user/update
     * Method: POST
     *
     * @param id       a id of the user to update.
     * @param username a new name to the user.
     * @param password a new password to the user.
     * @param role     a new role to the user.
     * @param locked   a new locked to the user.
     * @return The view name.
     */
    @RequestMapping(
            value = "/update/{id}",
            method = RequestMethod.POST
    )
    public String updateUser(
            @PathVariable("id") final long id,
            @RequestParam(value = "username", defaultValue = "") final String username,
            @RequestParam(value = "password", defaultValue = "") final String password,
            @RequestParam(value = "role", defaultValue = "CLIENT") final UserRole role,
            @RequestParam(value = "locked", defaultValue = "false") final boolean locked
    ) {
        User user = this.userService.get(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        user.setLocked(locked);
        this.userService.update(user);
        return "redirect:/home";
    }

    /**
     * Removes user with id and redirects by URL /home.
     * Request mapping: /admin/user/delete/{user_id}
     * Method: GET
     *
     * @param id a id of the user to remove.
     * @return The view name.
     */
    @RequestMapping(
            value = "/delete/{id}",
            method = RequestMethod.GET
    )
    public String deleteUser(@PathVariable("id") final long id) {
        this.userService.remove(id);
        return "redirect:/home";
    }
}
