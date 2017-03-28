package com.management.product.dao;

import com.management.product.entity.User;
import com.management.product.enums.UserRole;
import com.management.product.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * The class implements a set of standard methods for working {@link User}
 * objects with a database.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
@Repository
public class UserDaoImpl extends DataDaoImpl<User> implements UserDao {

    /**
     * The interface provides a set of JPA methods
     * for working {@link User} objects with a database.
     */
    private final UserRepository repository;

    /**
     * Constructor.
     *
     * @param repository a implementation of the interface provides a set of JPA methods
     *                   for working {@link User} objects with a database.
     */
    @Autowired
    public UserDaoImpl(final UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    /**
     * Returns user with the parameter username from a database.
     *
     * @param username a username of the user to return.
     * @return The user with parameter name.
     */
    @Override
    public User getByUsername(String username) {
        return this.repository.findByUsername(username);
    }

    /**
     * Removes user with the parameter username from a database.
     *
     * @param username a username of the user to remove.
     */
    @Override
    public void removeByUsername(String username) {
        this.repository.deleteByUsername(username);
    }

    /**
     * Returns all users with the input role.
     *
     * @param role a users role.
     * @return The all users with the input role.
     */
    @Override
    public Collection<User> getByUserRole(UserRole role) {
        return this.repository.findAllByRole(role);
    }
}
