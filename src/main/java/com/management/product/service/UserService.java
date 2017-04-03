package com.management.product.service;

import com.management.product.entity.User;
import com.management.product.enums.UserRole;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;

/**
 * The interface of the service layer, describes a set of methods
 * for working with objects of the class {@link User}.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public interface UserService extends DataService<User>, UserDetailsService {

    /**
     * Returns user which the parameter username.
     *
     * @param username a username of the user to return.
     * @return The user which the parameter username.
     */
    User getByUsername(String username);

    /**
     * Returns authenticated user.
     *
     * @return The authenticated user.
     */
    User getAuthenticatedUser();

    /**
     * Check if authenticated user is admin.
     *
     * @return {@code true} if authenticated user is admin,
     * {@code false} otherwise.
     */
    boolean isAuthenticatedAdmin();

    /**
     * Returns users with role "ADMIN".
     *
     * @return The all admin.
     */
    Collection<User> getAdmins();

    /**
     * Returns personnel.
     *
     * @return The all personnel.
     */
    Collection<User> getUsers();

    /**
     * Returns all users with the input role.
     *
     * @param role a users role.
     * @return The all users with the input role.
     */
    Collection<User> getByRole(UserRole role);

    /**
     * Removes user with the parameter username.
     *
     * @param username a username of the user to remove.
     */
    void removeByUsername(String username);
}
