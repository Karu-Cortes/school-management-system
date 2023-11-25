package org.adaschool.schoolmanagementsystem.model.enums;

public enum Version {
    VERSION1 ("versión 1"),
    VERSION2 ("versión 2"),
    VERSION3 ("versión 3");

    private final String value;

    Version(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
