package com.management.product.dao;

import com.management.product.entity.User;
import com.management.product.enums.UserRole;

import java.util.Collection;

/**
 * The interface provides a set of standard methods
 * for working {@link User} objects with a database.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public interface UserDao extends DataDao<User> {

    /**
     * Returns user with the parameter username from a database.
     *
     * @param username a username of the user to return.
     * @return The user with parameter name.
     */
    User getByUsername(String username);

    /**
     * Removes user with the parameter username from a database.
     *
     * @param username a username of the user to remove.
     */
    void removeByUsername(String username);

    /**
     * Returns all users with the input role.
     *
     * @param role a users role.
     * @return The all users with the input role.
     */
    Collection<User> getByUserRole(UserRole role);
}
