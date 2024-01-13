package org.example;

import java.util.ArrayList;

public class Visitor {
    private String name;
    private String phoneNumber;
    private int age;
    private float balance;
    private String email;
    private String password;
    private int membershipStatus;

    private ArrayList<Ticket> ticketList = new ArrayList<Ticket>();

    public ArrayList<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(ArrayList<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public float getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getMembershipStatus() {
        return membershipStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void buyMembership(Admin admin, String membershipCategory, String discountCode){
        float discount;
        if(admin.checkDiscountCode(discountCode) == null){
            discount = 0;
        }

        else{
            discount = admin.checkDiscountCode(discountCode).getPercentage();
        }

        if(membershipCategory.equals("basic") && this.balance >= 20*(1-discount/100)){
            if(this.membershipStatus != 0){
                System.out.println("You already have basic or above membership");
            }

            else{
                this.balance -= 20*(1-discount/100);
                admin.setRevenue(admin.totalRevenue() + 20*(1-discount/100));
                this.membershipStatus = 1;
            }
        }

        else if(membershipCategory.equals("premium") && this.balance >= 50*(1-discount/100)){
            if(this.membershipStatus == 2){
                System.out.println("You already have premium membership");
            }

            else{
                this.balance -= 50;
                admin.setRevenue(admin.totalRevenue() + 50*(1-discount/100));
                this.membershipStatus = 2;
            }
        }

        else{
            System.out.println("Insufficient balance");
        }
    }

    public void buyTicket(Admin admin, int attractionIndex, int numTickets){
        attractionIndex -= 1;
        if(this.membershipStatus == 0){
            System.out.println("Cannot buy tickets without a basic membership");
        }

        else if(this.membershipStatus == 2){
            System.out.println("Premium members do not need to buy tickets");
        }

        else{
            if(attractionIndex <= admin.getAttractionList().size() && attractionIndex >= 0){
                int ticketPrice = admin.getAttractionList().get(attractionIndex).getTicketPrice();
                int percentageDiscount = 0;

                if(admin.getDeal(numTickets) != null){
                    percentageDiscount = admin.getDeal(numTickets).getPercentageDiscount();
                }

                float realPrice = ticketPrice * numTickets * (1 - ((float) percentageDiscount / 100));

                if(this.balance >= realPrice) {
                    this.balance -= realPrice;
                    admin.setRevenue(admin.totalRevenue() + realPrice);
                    for(int i = 0; i<numTickets; i++){
                        Ticket ticket = new Ticket();
                        ticket.setAttraction(admin.getAttractionList().get(attractionIndex));
                        this.ticketList.add(ticket);
                    }

                    System.out.println("$" + realPrice + " has been spent, your current balance is " + this.balance);
                }

                else{
                    System.out.println("Insufficient balance");
                }
            }

            else{
                System.out.println("Enter valid option");
            }
        }
    }

    public void visitAttractions(Admin admin, int attractionIndex){
        attractionIndex -= 1;
        if(attractionIndex < admin.getAttractionList().size() && attractionIndex >= 0){
            Attraction desiredAttraction = admin.getAttractionList().get(attractionIndex);
            if(!desiredAttraction.isOpen()){
                System.out.println("This attraction has been temporarily closed");
                return;
            }

            if(this.membershipStatus == 2){
                System.out.println("Enjoy the premium benefits.");
                System.out.println("Thank you for visiting " +  desiredAttraction.getName() + ". Hope you enjoyed the attraction.");
                desiredAttraction.setVisits(desiredAttraction.getVisits()+1);
            }

            else if(this.membershipStatus == 1){
                boolean flag = false;
                for(Ticket ticket : this.ticketList){
                    if(ticket.getAttraction().equals(desiredAttraction)){
                        System.out.println("1 Ticket Used.");
                        System.out.println("Thank you for visiting " +  desiredAttraction.getName() + ". Hope you enjoyed the attraction.");
                        this.ticketList.remove(ticket);
                        flag = true;
                        break;
                    }
                }

                if(!flag){
                    System.out.println("Ticket not available. Basic Members need to buy separate tickets for the attractions.");
                }
            }

            else{
                System.out.println("You need to buy a membership first.");
            }
        }

        else{
            System.out.println("Enter valid option");
        }
    }

    public void feedAnimal(Admin admin, int animalIndex){
        animalIndex -= 1;
        if(animalIndex < admin.getAnimalList().size() && animalIndex >= 0){
            Animal myAnimal = admin.getAnimalList().get(animalIndex);
            System.out.println("Feeding " + myAnimal.getName() + "...");
            System.out.println(myAnimal.getNoise());
        }
    }

    public void readAnimalDetails(Admin admin, int animalIndex){
        animalIndex -= 1;
        if(animalIndex < admin.getAnimalList().size() && animalIndex >= 0){
            Animal myAnimal = admin.getAnimalList().get(animalIndex);
            System.out.println("Reading history of " + myAnimal.getName());
            System.out.println(myAnimal.getDetails());
        }
    }
    public void viewDiscount(Admin admin){
        int count = 1;
        for(Discount discount: admin.getDiscountList()){
            System.out.print(count + ". " + discount.getCategory() + " ");
            System.out.print("(" + discount.getPercentage() + "% discount) - ");
            System.out.println(discount.getCode());
        }
    }

    public void viewSpecialDeals(Admin admin){
        int count = 1;
        for(Deal deal: admin.getDealList()){
            System.out.println(count + ". " + "Buy " + deal.numTickets + " tickets and get " + deal.percentageDiscount + "% off");
        }
    }

    public void viewAttractions(Admin admin){
        admin.viewAttractions();
    }

    public void viewAnimals(Admin admin){
        admin.viewAnimals();
    }

    public void leaveFeedback(Admin admin, String feedback){
        if(feedback.length() > 200){
            System.out.println("Maximum 200 characters are allowed");
        }

        else{
            admin.getFeedbackList().add(feedback);
        }
    }
}
