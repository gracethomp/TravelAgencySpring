package com.kpi.travelagency.constants;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER("User", Set.of(Permission.CREATE_ORDER, Permission.MANAGE_ORDER, Permission.CANCEL_ORDER)),

    MANAGER("Manager", Set.of(Permission.CREATE_ORDER, Permission.MANAGE_ORDER,  Permission.CANCEL_ORDER,
            Permission.MANAGE_TOUR, Permission.DELETE_TOUR, Permission.VIEW_STATISTICS, Permission.MANAGE_USERS)),

    SYSTEM_ADMIN("Manager", Set.of(Permission.CREATE_ORDER, Permission.MANAGE_ORDER, Permission.CANCEL_ORDER,
            Permission.MANAGE_TOUR, Permission.DELETE_TOUR, Permission.VIEW_STATISTICS, Permission.MANAGE_USERS,
            Permission.DELETE_USERS, Permission.GRANT_ROLES));

    private final Set<Permission> permissions;
    private final String name;

    Role(String name, Set<Permission> permissions) {
        this.permissions = permissions;
        this.name = name;
    }

    public Set<Permission> getPermissions(){
        return permissions;
    }

    public String getName(){
        return name;
    }

    /*
    public Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                .collect(Collectors.toSet());
    }
    */

}
