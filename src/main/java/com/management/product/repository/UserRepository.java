package com.management.product.repository;

import com.management.product.entity.User;
import com.management.product.enums.UserRole;

import java.util.Collection;

/**
 * The interface provides a set of JPA methods
 * for working {@link User} objects with a database.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
public interface UserRepository extends DataRepository<User> {

    /**
     * Returns user from a database,
     * which matches the parameter username.
     *
     * @param username a username of the user to return.
     * @return The object of class {@link User}.
     */
    User findByUsername(String username);

    /**
     * Removes user from a database,
     * which matches the parameter username.
     *
     * @param username a username of the user to remove.
     */
    void deleteByUsername(String username);

    Collection<User> findAllByRole(UserRole role);
}
