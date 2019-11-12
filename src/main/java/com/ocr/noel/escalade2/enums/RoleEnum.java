package com.ocr.noel.escalade2.enums;

public enum RoleEnum {

    ROLE_USER(1, "ROLE_USER"),
    ROLE_ADMIN(2, "ROLE_ADMIN");

    private int num;
    private String name;

    RoleEnum(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }
}
