package com.management.product.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The authorization controller.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
@Controller
public class AuthorizationController {

    @RequestMapping(
            value = "/login",
            method = RequestMethod.GET
    )
    public String loginPage() {
        return "login";
    }

    /**
     * Logout user and redirects to /login?logout.
     *
     * @param modelAndView a object of class ModelAndView for to update.
     * @param request      a implementation of the interface to provide
     *                     request information for HTTP servlets.
     * @param response     a implementation of the interface to provide
     *                     response information for HTTP servlets.
     * @return The ready object of class ModelAndView.
     */
    @RequestMapping(
            value = "/logout",
            method = RequestMethod.GET
    )
    public ModelAndView logoutPage(
            final ModelAndView modelAndView,
            final HttpServletRequest request,
            final HttpServletResponse response
    ) {
        new SecurityContextLogoutHandler().logout(
                request, response,
                SecurityContextHolder.getContext().getAuthentication()
        );
        modelAndView.setViewName("redirect:/login?logout");
        return modelAndView;
    }
}
