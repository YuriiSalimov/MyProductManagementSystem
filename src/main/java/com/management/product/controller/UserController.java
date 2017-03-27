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
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/admin/user")
@ComponentScan(basePackages = "com.management.product.service")
@SuppressWarnings("SpringMVCViewInspection")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

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

    @RequestMapping(
            value = "/delete/{id}",
            method = RequestMethod.GET
    )
    public String deleteUser(@PathVariable("id") final long id) {
        this.userService.remove(id);
        return "redirect:/home";
    }
}
