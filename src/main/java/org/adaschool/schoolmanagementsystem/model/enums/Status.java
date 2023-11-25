package org.adaschool.schoolmanagementsystem.model.enums;

public enum Status {
    MATRICULA("matriculado"),
    INACTIVO("inactivo"),
    GRADUADO("graduado");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

