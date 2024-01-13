package org.example;

public abstract class Animal {
    private String name;
    private String noise;
    private String details;

    public String getName() {
        return name;
    }

    public String getNoise() {
        return noise;
    }

    public String getDetails() {
        return details;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {}

    public void setNoise(String noise) {
        this.noise = noise;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}


