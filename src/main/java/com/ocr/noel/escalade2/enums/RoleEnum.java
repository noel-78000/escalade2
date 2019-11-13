package com.ocr.noel.escalade2.enums;

public enum RoleEnum {

    ROLE_USER(1, "ROLE_USER"),
    ROLE_ASSO(2, "ROLE_ASSO");

    private byte num;
    private String name;

    RoleEnum(int num, String name) {
        this.num = (byte) num;
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public byte getNum() {
        return num;
    }

    public String getName() {
        return name;
    }
}
