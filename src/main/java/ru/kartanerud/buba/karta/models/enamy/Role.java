package ru.kartanerud.buba.karta.models.enamy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Entity;
import java.util.Set;
import java.util.stream.Collectors;

public enum Role implements GrantedAuthority {

    ADMIN(Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE)),
    USER(Set.of(Permission.DEVELOPERS_READ)),
    CLIENT(Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE)),
    MANAGER(Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE)),
    PEREVOZCHIK(Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE)),
    KARIERKAB(Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE)),
    VODITEL(Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE)),
    PEREVALKA(Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE));

    private final Set<Permission>permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
    public Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
