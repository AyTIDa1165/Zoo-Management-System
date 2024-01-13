package org.example;

public class Discount {
    private String category;
    private int percentage;
    private String code;


    public String getCategory() {
        return category;
    }

    public int getPercentage() {
        return percentage;
    }

    public String getCode() {
        return code;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
