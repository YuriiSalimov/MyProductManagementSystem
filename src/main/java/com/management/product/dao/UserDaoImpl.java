package com.management.product.dao;

import com.management.product.entity.User;
import com.management.product.enums.UserRole;
import com.management.product.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
@Repository
public final class UserDaoImpl extends DataDaoImpl<User> implements UserDao {

    private final UserRepository repository;

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

    @Override
    public Collection<User> getByUserRole(UserRole role) {
        return this.repository.findAllByRole(role);
    }
}
