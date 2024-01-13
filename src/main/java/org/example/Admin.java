package org.example;
import java.util.ArrayList;
import java.util.Locale;

interface attractionManagement{
    void addAttraction(String s1, String s2, int i);
    void viewAttractions();
    void modifyAttraction(int i1, int i2);
    void removeAttraction(int i);
}

interface animalManagement{
    void addAnimal(String s1, String s2, String s3, String s4);
    void updateAnimalDetails(int i, String s2);
    void removeAnimal(int i);
}

interface setDiscount{
    void addDiscount(String s1, int i, String s2);
    void modifyDiscount(String s, int i);
    void removeDiscount(String s);
}

interface visitorStats{
    int totalVisitors();
    float totalRevenue();
    Attraction mostPopularAttraction();
}
public class Admin implements attractionManagement, animalManagement, setDiscount, visitorStats{
    private static String username = "admin";
    private static String password = "admin123";

    private float revenue;

    private ArrayList<Visitor> visitorList = new ArrayList<Visitor>();

    private ArrayList<Attraction> attractionList = new ArrayList<Attraction>();

    private ArrayList<Animal> animalList = new ArrayList<Animal>();

    private ArrayList<Discount> discountList = new ArrayList<Discount>();

    private ArrayList<String> feedbackList = new ArrayList<String>();

    private ArrayList<Deal> dealList = new ArrayList<Deal>();

    public ArrayList<Animal> getAnimalList() {
        return animalList;
    }

    public ArrayList<Attraction> getAttractionList() {
        return attractionList;
    }

    public ArrayList<Discount> getDiscountList() {
        return discountList;
    }

    public ArrayList<Deal> getDealList() {
        return dealList;
    }

    public ArrayList<String> getFeedbackList() {
        return feedbackList;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public void addVisitor(Visitor v){
        visitorList.add(v);
    }

    public Visitor getVisitor(String checkEmail, String checkPassword){
        for(Visitor v: visitorList){
            if(v.getEmail().equals(checkEmail) && v.getPassword().equals(checkPassword)){
                return v;
            }
        }
        return null;
    }

    public Deal getDeal(int numTickets){
        for(Deal deal: dealList){
            if(deal.numTickets == numTickets){
                return deal;
            }
        }

        return null;
    }

    public boolean addDeal(int numTickets, int percentDiscount){
        if(this.getDeal(numTickets) == null){
            Deal deal = new Deal();
            deal.setNumTickets(numTickets);
            deal.setPercentageDiscount(percentDiscount);
            this.dealList.add(deal);
            return true;
        }
        return false;
    }

    @Override
    public void addAttraction(String attractionName, String attractionDescription, int ticketPrice) {
        Attraction attraction = new Attraction();
        attraction.setName(attractionName);
        attraction.setDescription(attractionDescription);
        attraction.setTicketPrice(ticketPrice);
        attraction.setVisits(0);
        attraction.setOpen(true);
        attractionList.add(attraction);
    }

    @Override
    public void viewAttractions() {
        int count = 1;
        for(Attraction attraction : attractionList){
            System.out.println(count + ". " + attraction.getName() + " (₹" + attraction.getTicketPrice() + ")");
            count++;
        }
    }

    @Override
    public void modifyAttraction(int attractionIndex, int attractionTicketPrice) {
        attractionIndex--;
        if(attractionIndex < attractionList.size() && attractionIndex>=0){
            attractionList.get(attractionIndex).setTicketPrice(attractionTicketPrice);
        }
        else{
            System.out.println("Enter valid option");
        }
    }

    @Override
    public void removeAttraction(int attractionIndex) {
        attractionIndex--;
        if(attractionIndex < attractionList.size() && attractionIndex>=0) {
            attractionList.remove(attractionList.get(attractionIndex));
        }

        else{
            System.out.println("Enter valid option");
        }
    }

    @Override
    public void addAnimal(String animalName, String animalType, String animalNoise, String animalDescription) {

        Animal animal;
        switch (animalType.toLowerCase(Locale.ROOT)) {
            case "mammal" -> animal = new Mammal();
            case "amphibian" -> animal = new Amphibian();
            case "reptile" -> animal = new Reptile();
            default -> {
                System.out.println("Define animal type properly");
                return;
            }
        }

        animal.setName(animalName);
        animal.setType(animalType);
        animal.setNoise(animalNoise);
        animal.setDetails(animalDescription);

        animalList.add(animal);
        System.out.println("animal added to zoo");
    }

    @Override
    public void updateAnimalDetails(int animalIndex, String animalDescription) {
        animalIndex--;
        if(animalIndex<animalList.size() && animalIndex>=0){
            animalList.get(animalIndex).setDetails(animalDescription);
        }

        else{
            System.out.println("Enter valid option");
        }
    }

    @Override
    public void removeAnimal(int animalIndex) {
        animalIndex--;
        if(animalIndex<animalList.size() && animalIndex>=0) {
            animalList.remove(animalList.get(animalIndex));
        }

        else{
            System.out.println("Enter valid option");
        }
    }

    public void viewAnimals(){
        int count = 1;
        for(Animal animal: this.getAnimalList()) {
            System.out.println(count + ". " + animal.getName());
            count++;
        }
    }

    @Override
    public void addDiscount(String discountCategory, int discountPercentage, String discountCode) {
        Discount discount = new Discount();
        discount.setCategory(discountCategory);
        discount.setPercentage(discountPercentage);
        discount.setCode(discountCode);

        discountList.add(discount);
    }

    @Override
    public void modifyDiscount(String discountCategory, int discountPercentage) {
        for(Discount discount : discountList){
            if(discount.getCategory().equals(discountCategory)){
                discount.setPercentage(discountPercentage);
                break;
            }
        }
    }

    @Override
    public void removeDiscount(String discountCode) {
        for(Discount discount : discountList){
            if(discount.getCode().equals(discountCode)){
                discountList.remove(discount);
                break;
            }
        }
    }

    public Discount checkDiscountCode(String discountCode){
        for(Discount discount : discountList){
            if(discount.getCode().equals(discountCode)){
                return discount;
            }
        }
        return null;
    }

    @Override
    public int totalVisitors() {
        return visitorList.size();
    }

    @Override
    public float totalRevenue() {
        return this.revenue;
    }

    @Override
    public Attraction mostPopularAttraction() {
        Attraction bestAttraction = this.getAttractionList().get(0);
        for(Attraction attraction: attractionList){
            if(attraction.getVisits() > bestAttraction.getVisits()){
                bestAttraction = attraction;
            }

            else if(attraction.getVisits() == bestAttraction.getVisits()){
                if(attraction.getTicketPrice() > bestAttraction.getTicketPrice()){
                    bestAttraction = attraction;
                }
            }
        }

        return bestAttraction;
    }

    public void schedule(int attractionIndex, int openClose){
        attractionIndex--;
        if(attractionIndex < attractionList.size() && attractionIndex>=0){
            if(openClose == 1){
                attractionList.get(attractionIndex).setOpen(true);
            }

            else if(openClose == 2){
                attractionList.get(attractionIndex).setOpen(false);
            }

            else{
                System.out.println("Enter valid option");
            }
        }
        else{
            System.out.println("Enter valid option");
        }
    }

    public void viewFeedback(){
        System.out.println("Feedbacks: ");
        int count = 1;
        for(String feedback: feedbackList){
            System.out.println(count + ". " + feedback);
        }
        System.out.println("\n");
    }
}