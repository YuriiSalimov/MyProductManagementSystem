package com.management.product.entity;

import com.management.product.enums.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * The class implements a set of standard methods for working
 * with entity of the {@link User} class.
 *
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
@Entity
@Table(name = "users")
public class User extends Model implements UserDetails {

    /**
     * It is used during deserialization to verify that
     * the sender and receiver of a serialized object have
     * loaded classes for that object that are compatible
     * with respect to serialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The name of a user.
     */
    @Column(name = "username", nullable = false)
    private String username;

    /**
     * The password of a user.
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * The role of a user.
     */
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    /**
     * Locked the user or not.
     */
    @Column(name = "locked")
    private boolean isLocked;

    /**
     * Default constructor.
     */
    public User() {
        this.username = "";
        this.password = "";
        this.role = UserRole.USER;
    }

    /**
     * Constructor.
     *
     * @param username a name of the new user.
     */
    public User(String username) {
        this();
        setUsername(username);
    }

    /**
     * Constructor.
     *
     * @param username a name of the new user.
     * @param password a password of the new user.
     */
    public User(String username, String password) {
        this(username);
        setPassword(password);
    }

    /**
     * Constructor.
     *
     * @param username a name of the new user.
     * @param password a password of the new user.
     * @param role     a role of the new user.
     */
    public User(String username, String password, UserRole role) {
        this(username, password);
        setRole(role);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "User{" + super.toString() +
                "username='" + this.username + '\'' +
                ", password='" + this.password + '\'' +
                ", role=" + this.role +
                ", isLocked=" + this.isLocked +
                '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param object The reference object with which to compare.
     * @return Returns true if this object is the same as the obj
     * argument, otherwise returns false.
     */
    @Override
    public boolean equals(Object object) {
        boolean result = super.equals(object);
        if (result) {
            User user = (User) object;
            result = this.username.equals(user.username) &&
                    this.password.equals(user.password) &&
                    (this.role == user.role);
        }
        return result;
    }

    /**
     * Returns a hash code value for the object.
     * This method is supported for the benefit
     * of hash tables such as those provided by HashMap.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        int result = this.username.hashCode();
        result = 31 * result + this.password.hashCode();
        result = 31 * result + this.role.hashCode();
        return result;
    }

    /**
     * Indicates whether the user's account has expired.
     * An expired account cannot be authenticated.
     *
     * @return {@code true} if the user's account is valid (ie non-expired),
     * {@code false} if no longer valid (ie expired)
     */
    @Override
    public boolean isAccountNonExpired() {
        return !this.isLocked;
    }

    /**
     * Indicates whether the user is locked or unlocked.
     * A locked user cannot be authenticated.
     *
     * @return {@code true} if the user is not locked, {@code false} otherwise.
     */
    @Override
    public boolean isAccountNonLocked() {
        return !this.isLocked;
    }

    /**
     * Indicates whether the user's credentials (password) has expired.
     * Expired credentials prevent authentication.
     *
     * @return {@code true} if the user's credentials are valid
     * (ie non-expired), {@code false} if no longer valid (ie expired)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return !this.isLocked;
    }

    /**
     * Indicates whether the user is enabled or disabled.
     * A disabled user cannot be authenticated.
     *
     * @return {@code true} if the user's credentials are valid
     * (ie non-expired), {@code false} if no longer valid (ie expired)
     */
    @Override
    public boolean isEnabled() {
        return !this.isLocked;
    }

    /**
     * Returns the authorities granted to the user.
     * Cannot return {@code null}.
     *
     * @return the authorities, sorted by natural key (never {@code null})
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> roles = new ArrayList<>(1);
        roles.add(new SimpleGrantedAuthority("ROLE_" + getRole().name()));
        return roles;
    }

    /**
     * Returns the user username.
     *
     * @return the username or the empty string (never {@code null}).
     */
    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets a new name to the user.
     * If parameter name is blank, then sets empty string.
     *
     * @param username a new name to the user.
     */
    public void setUsername(String username) {
        this.username = isNotBlank(username) ? username : "";
    }

    /**
     * Returns the user password.
     *
     * @return the password or the empty string (never {@code null}).
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets a new password to the user.
     * If parameter password is blank, then sets empty string.
     *
     * @param password a new password to the user.
     */
    public void setPassword(String password) {
        this.password = isNotBlank(password) ? password : "";
    }

    /**
     * Returns the user role.
     *
     * @return the used role (never {@code null}).
     */
    public UserRole getRole() {
        return this.role;
    }

    /**
     * Sets a new role to the user.
     * If parameter role is {@code null}, then sets USER role.
     *
     * @param role a new role to the user.
     */
    public void setRole(UserRole role) {
        this.role = (role != null) ? role : UserRole.USER;
    }

    /**
     * Returns the value of the locked user or not.
     *
     * @return The value of the locked user or not.
     */
    public boolean isLocked() {
        return this.isLocked;
    }

    /**
     * Sets the value of the locked user or not.
     *
     * @param locked a value of locked the user or not.
     */
    public void setLocked(final boolean locked) {
        this.isLocked = locked;
    }
}
