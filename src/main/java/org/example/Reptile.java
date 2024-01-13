package org.example;

public class Reptile extends Animal{
    private String type;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDetails(){
        return this.getName() + " is a " + this.getType() + "\n" + super.getDetails();
    }
}
