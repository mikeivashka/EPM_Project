package by.epam.dietmanager.collections;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,
    ADMIN,
    NUTRITIONIST,
    CLIENT;

    @Override
    public String getAuthority() {
        return name();
    }
}
