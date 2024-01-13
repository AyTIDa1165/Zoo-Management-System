package org.example;

public class Attraction {
    private String name;
    private String description;
    private int visits;
    private int ticketPrice;
    private boolean open;

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getVisits() {
        return visits;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public boolean isOpen() {
        return open;
    }
}
