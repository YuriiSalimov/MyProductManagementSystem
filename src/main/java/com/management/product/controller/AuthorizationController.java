package com.management.product.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    /**
     * Login user.
     *
     * @return The ready object of class ModelAndView.
     */
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
    public String logoutPage(
            final HttpServletRequest request,
            final HttpServletResponse response
    ) {
        new SecurityContextLogoutHandler().logout(
                request, response,
                SecurityContextHolder.getContext().getAuthentication()
        );
        return "redirect:/login?logout";
    }
}
