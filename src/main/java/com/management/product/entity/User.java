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
 * @author Yurii Salimov (yuriy.alex.salimov@gmail.com)
 * @version 1.0
 */
@Entity
@Table(name = "users")
public final class User extends Model implements UserDetails {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    /**
     * Locked the user or not.
     */
    @Column(name = "locked")
    private boolean isLocked;

    public User() {
        this.username = "";
        this.password = "";
        this.role = UserRole.USER;
    }

    public User(String username) {
        this();
        setUsername(username);
    }

    public User(String username, String password) {
        this(username);
        setPassword(password);
    }

    public User(String username, String password, UserRole role) {
        this(username, password);
        setRole(role);
    }

    @Override
    public String toString() {
        return "User{" + super.toString() +
                "username='" + this.username + '\'' +
                ", password='" + this.password + '\'' +
                ", role=" + this.role +
                ", isLocked=" + this.isLocked +
                '}';
    }

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
     * Returns the username used to authenticate the user.
     * Cannot return {@code null}. Return the empty string
     * if username is {@code null}.
     *
     * @return the username or the empty string (never {@code null}).
     */
    @Override
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = isNotBlank(username) ? username : "";
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = isNotBlank(password) ? password : "";
    }

    public UserRole getRole() {
        return this.role;
    }

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
