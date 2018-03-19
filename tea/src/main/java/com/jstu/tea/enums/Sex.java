package com.jstu.tea.enums;

public enum Sex {
    MALE('男'), FEMALE('女');

    private Character sex;

    private Sex(Character sex) {
        this.sex = sex;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

}
