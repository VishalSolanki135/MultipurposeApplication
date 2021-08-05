package com.example.vishal;

import android.content.Intent;

public class IntentClass {
    private int NO_IMAGE_PROVIDED = -1;
    private String name;
    private int resource=NO_IMAGE_PROVIDED;

    public IntentClass(String name, int resource) {
        this.name = name;
        this.resource =resource;
    }

    public String getName() {
        return name;
    }

    public int getResource() {
        return resource;
    }
}
