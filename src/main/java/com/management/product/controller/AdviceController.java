package com.management.product.controller;

import org.apache.log4j.Logger;
import org.springframework.data.mapping.model.IllegalMappingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * Class intercepts exceptions that are not specified in the controller.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
@ControllerAdvice
public class AdviceController {

    /**
     * The object for logging information.
     */
    private static final Logger LOGGER = Logger.getLogger(AdviceController.class);

    /**
     * Intercepts and handles NoHandlerFoundException.
     *
     * @param ex      an intercepted exception.
     * @param request to provide requested information for HTTP servlets.
     * @return The ModelAndView object with information about exception.
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ModelAndView noHandlerFoundException(
            final NoHandlerFoundException ex,
            final HttpServletRequest request
    ) {
        return handleException(ex, request, HttpStatus.NOT_FOUND);
    }

    /**
     * Intercepts and handles NullPointerException.
     *
     * @param ex      an intercepted exception.
     * @param request to provide requested information for HTTP servlets.
     * @return The ModelAndView object with information about exception.
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ModelAndView nullPointerException(
            final NullPointerException ex,
            final HttpServletRequest request
    ) {
        return handleException(ex, request, HttpStatus.BAD_REQUEST);
    }

    /**
     * Intercepts and handles IllegalArgumentException.
     *
     * @param ex      an intercepted exception.
     * @param request to provide requested information for HTTP servlets.
     * @return The ModelAndView object with information about exception.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ModelAndView illegalArgumentException(
            final IllegalArgumentException ex,
            final HttpServletRequest request
    ) {
        return handleException(ex, request, HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     * Intercepts and handles HttpRequestMethodNotSupportedException.
     *
     * @param ex      an intercepted exception.
     * @param request to provide requested information for HTTP servlets.
     * @return The ModelAndView object with information about exception.
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public ModelAndView httpRequestMethodNotSupportedException(
            final HttpRequestMethodNotSupportedException ex,
            final HttpServletRequest request
    ) {
        return handleException(ex, request, HttpStatus.UNAUTHORIZED);
    }

    /**
     * Intercepts and handles IllegalAccessException.
     *
     * @param ex      an intercepted exception.
     * @param request to provide requested information for HTTP servlets.
     * @return The ModelAndView object with information about exception.
     */
    @ExceptionHandler(IllegalAccessException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ModelAndView illegalAccessException(
            final IllegalAccessException ex,
            final HttpServletRequest request
    ) {
        return handleException(ex, request, HttpStatus.FORBIDDEN);
    }

    /**
     * Intercepts and handles IllegalMappingException.
     *
     * @param ex      an intercepted exception.
     * @param request to provide requested information for HTTP servlets.
     * @return The ModelAndView object with information about exception.
     */
    @ExceptionHandler(IllegalMappingException.class)
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    public ModelAndView illegalMappingException(
            final IllegalMappingException ex,
            final HttpServletRequest request
    ) {
        return handleException(ex, request, HttpStatus.METHOD_NOT_ALLOWED);
    }

    /**
     * Intercepts and handles all other Exception.
     *
     * @param ex      an intercepted exception.
     * @param request to provide requested information for HTTP servlets.
     * @return The ModelAndView object with information about exception.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView otherException(
            final Exception ex,
            final HttpServletRequest request
    ) {
        return handleException(ex, request, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles all other Exception.
     *
     * @param ex      an intercepted exception.
     * @param request to provide requested information for HTTP servlets.
     * @param status  a http status.
     * @return The ModelAndView object with information about exception.
     */
    private ModelAndView handleException(
            final Exception ex,
            final HttpServletRequest request,
            final HttpStatus status
    ) {
        logRequest(request);
        logException(ex);
        return prepareModelAndView(
                status,
                ex.getClass().getSimpleName() + " : " + ex.getMessage()
        );
    }

    /**
     * Creates and return ModelAndView object.
     *
     * @param status  a http status.
     * @param message a message of the exception.
     * @return The ModelAndView object with information about exception.
     */
    @SuppressWarnings("SpringMVCViewInspection")
    private ModelAndView prepareModelAndView(
            final HttpStatus status,
            final String message
    ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("status", status.value());
        modelAndView.addObject("message", message);
        modelAndView.setViewName("error");
        return modelAndView;
    }

    /**
     * Request logging.
     *
     * @param request to provide requested information for HTTP servlets.
     */
    private static void logRequest(final HttpServletRequest request) {
        if (request != null) {
            LOGGER.error(request.getRemoteAddr() + " : " + request.getRequestURL());
        }
    }

    /**
     * Error logging.
     *
     * @param ex an intercepted exception.
     */
    private static void logException(final Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        ex.printStackTrace();
    }
}
