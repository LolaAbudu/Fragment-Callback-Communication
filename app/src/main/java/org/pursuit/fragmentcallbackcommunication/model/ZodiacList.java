package org.pursuit.fragmentcallbackcommunication.model;

import java.util.List;

public class ZodiacList {
    private List<Zodiac> zodiac;

    public ZodiacList(List<Zodiac> zodiac) {
        this.zodiac = zodiac;
    }

    public List<Zodiac> getZodiac() {
        return zodiac;
    }

    public void setZodiac(List<Zodiac> zodiac) {
        this.zodiac = zodiac;
    }
}
