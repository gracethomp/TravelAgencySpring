package com.kpi.travelagency.constants;

public enum Permission {
    CREATE_ORDER("Create order"),
    MANAGE_ORDER("Manage order"),
    CANCEL_ORDER("Cancel order"),

    MANAGE_TOUR("Manage tour"),
    DELETE_TOUR("Delete tour"),
    VIEW_STATISTICS("View statistics"),
    MANAGE_USERS("Manage users"),

    DELETE_USERS("Delete user"),
    GRANT_ROLES("Grant roles");

    private final String name;

    Permission(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
