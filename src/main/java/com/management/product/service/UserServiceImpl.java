package com.management.product.service;

import com.management.product.entity.User;
import com.management.product.enums.UserRole;
import com.management.product.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * The class of the service layer, implements a set of methods for working
 * with objects of the {@link User} class.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
@Service
public class UserServiceImpl extends DataServiceImpl<User> implements UserService, UserDetailsService {

    /**
     * The interface provides a set of standard methods for working
     * {@link User} objects with the database.
     */
    private final UserRepository repository;

    /**
     * Constructor.
     *
     * @param repository a implementation of the {@link UserRepository} interface.
     */
    @Autowired
    public UserServiceImpl(final UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    /**
     * Returns authenticated user.
     *
     * @return The authenticated user.
     */
    @Override
    @Transactional(readOnly = true)
    public User getAuthenticatedUser() {
        User user;
        try {
            user = (User) SecurityContextHolder.getContext()
                    .getAuthentication().getPrincipal();
        } catch (ClassCastException ex) {
            user = new User("anonymousUser");
        }
        return user;
    }

    /**
     *
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public boolean isAuthenticatedAdmin() {
        return getAuthenticatedUser().getRole().equals(UserRole.ADMIN);
    }

    /**
     * Locates the user based on the username.
     *
     * @param username The username identifying the user whose data is required.
     * @return A fully populated user record (never {@code null}).
     * @throws UsernameNotFoundException if the user could not be found
     *                                   or the user has no GrantedAuthority.
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user;
        try {
            user = getByUsername(username);
        } catch (NullPointerException ex) {
            throw new UsernameNotFoundException(ex.getMessage(), ex);
        }
        return user;
    }

    /**
     * Returns user with the parameter username.
     *
     * @param username a name of the user to return.
     * @return The user with the parameter username or {@code null}.
     * @throws IllegalArgumentException Throw exception when parameter username is blank.
     * @throws NullPointerException     Throws exception if user is absent.
     */
    @Override
    @Transactional(readOnly = true)
    public User getByUsername(final String username)
            throws IllegalArgumentException, NullPointerException {
        if (isBlank(username)) {
            throw new IllegalArgumentException("Input name is blank!");
        }
        final User user = this.repository.findByUsername(username);
        if (user == null) {
            throw new NullPointerException("Can`t find user by name \"" + username + "\"!");
        }
        return user;
    }

    /**
     * Returns users with role {@code ADMIN}.
     *
     * @return The users with role {@code ADMIN}.
     */
    @Override
    @Transactional(readOnly = true)
    public Collection<User> getAdmins() {
        return getByRole(UserRole.ADMIN);
    }

    /**
     * Returns users with role {@code USER}.
     *
     * @return The users with role {@code USER}.
     */
    @Override
    @Transactional(readOnly = true)
    public Collection<User> getUsers() {
        return getByRole(UserRole.USER);
    }

    /**
     * Returns all users with the input role.
     *
     * @param role a users role.
     * @return The all users with the input role.
     * @throws IllegalArgumentException Throw exception when parameter role is {@code null}.
     */
    @Override
    @Transactional(readOnly = true)
    public Collection<User> getByRole(final UserRole role) throws IllegalArgumentException {
        if (role == null) {
            throw new IllegalArgumentException("Input user role is null!");
        }
        return this.repository.findAllByRole(role);
    }

    /**
     * Removes user with the parameter username.
     * Removes user if username is not blank.
     *
     * @param username a name of the user to remove.
     */
    @Override
    @Transactional
    public void removeByUsername(final String username) {
        if (isNotBlank(username)) {
            this.repository.deleteByUsername(username);
        }
    }

    /**
     * Return Class object of {@link User} class.
     *
     * @return The Class object of {@link User} class.
     */
    @Override
    protected Class<User> getModelClass() {
        return User.class;
    }
}
