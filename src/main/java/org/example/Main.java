package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to ZOOtopia!\n");

        Admin admin = new Admin();
        admin.setRevenue(0);

        //..............................................................................................................
        admin.addAttraction("Jungle Safari", "Exciting adventure", 40);
        admin.addAnimal("Tiger", "mammal", "Roar", "Carnivorous");
        admin.addDiscount("Students", 15, "iiit123");
        admin.addDeal(3, 50);
        Visitor testvisitor = new Visitor();
        testvisitor.setName("aditya");
        testvisitor.setPassword("abcd");
        testvisitor.setEmail("@");
        testvisitor.setBalance(500);
        testvisitor.setPhoneNumber("1234567890");
        testvisitor.setAge(19);
        admin.addVisitor(testvisitor);
        //..............................................................................................................

        while(true){
            System.out.println("""
                    1. Enter as Admin
                    2. Enter as a Visitor
                    3. Exit
                    
                    Enter your choice:
                    """);

            Scanner sc_homeQ = new Scanner(System.in);
            int homeQuestion = sc_homeQ.nextInt();
            if(homeQuestion == 1) {
                System.out.println("Enter Admin Username: ");
                Scanner sc_adminName = new Scanner(System.in);
                String adminName = sc_adminName.nextLine();

                System.out.println("Enter Admin Password: ");
                Scanner sc_adminPass = new Scanner(System.in);
                String adminPass = sc_adminPass.nextLine();

                if (adminName.equals(Admin.getUsername()) && adminPass.equals(Admin.getPassword())) {
                    System.out.println("Logged in as Admin.");

                    while (true) {
                        System.out.println("""
                                Admin Menu:
                                1. Manage Attractions
                                2. Manage Animals
                                3. Schedule Events
                                4. Set Discounts
                                5. Set Special Deal
                                6. View Visitor Stats
                                7. View Feedback
                                8. Exit

                                Enter your choice:
                                """);

                        Scanner sc_adminQ = new Scanner(System.in);
                        int adminQ = sc_adminQ.nextInt();

                        if(adminQ == 1) {
                            //manage attractions
                            System.out.println("""
                                    Manage Attractions:
                                    1. Add Attraction
                                    2. View Attractions
                                    3. Modify Attraction
                                    4. Remove Attraction
                                    5. Exit

                                    Enter your choice:
                                    """);


                            Scanner sc_attractionQ = new Scanner(System.in);
                            int attractionQ = sc_attractionQ.nextInt();

                            if (attractionQ == 1) {
                                System.out.println("Enter Attraction Name: ");
                                Scanner sc_attractionName = new Scanner(System.in);
                                String attractionName = sc_attractionName.nextLine();

                                System.out.println("Enter Attraction Description: ");
                                Scanner sc_attractionDescription = new Scanner(System.in);
                                String attractionDescription = sc_attractionDescription.nextLine();

                                System.out.println("Enter ticket price: ");
                                Scanner sc_ticketPrice = new Scanner(System.in);
                                int ticketPrice = sc_ticketPrice.nextInt();

                                admin.addAttraction(attractionName, attractionDescription, ticketPrice);

                            } else if (attractionQ == 2) {
                                admin.viewAttractions();

                            } else if (attractionQ == 3) {
                                admin.viewAttractions();

                                System.out.println("Enter attraction index you want to modify: ");
                                Scanner sc_attractionIndex = new Scanner(System.in);
                                int attractionIndex = sc_attractionIndex.nextInt();

                                System.out.println("Enter new ticket price: ");
                                Scanner sc_attractionTicketPrice = new Scanner(System.in);
                                int attractionTicketPrice = sc_attractionTicketPrice.nextInt();

                                admin.modifyAttraction(attractionIndex, attractionTicketPrice);
                            } else if (attractionQ == 4) {
                                admin.viewAttractions();

                                System.out.println("Enter attraction index you want to remove: ");
                                Scanner sc_attractionIndex = new Scanner(System.in);
                                int attractionIndex = sc_attractionIndex.nextInt();

                                admin.removeAttraction(attractionIndex);
                            } else if (attractionQ == 5) {
                                System.out.println("Exiting");
                            }
                        }

                        if(adminQ == 2){
                            //manage animals
                            System.out.println("""
                                    Manage Animals:
                                    1. Add Animal
                                    2. Update Animal Details
                                    3. Remove Animal
                                    4. Exit

                                    Enter your choice:\s
                                    """);

                            Scanner sc_animalQ = new Scanner(System.in);
                            int animalQ = sc_animalQ.nextInt();

                            if(animalQ == 1){
                                System.out.println("Enter animal name: ");
                                Scanner sc_animalName = new Scanner(System.in);
                                String animalName = sc_animalName.nextLine();

                                System.out.println("Enter Animal Type: ");
                                Scanner sc_animalType = new Scanner(System.in);
                                String animalType = sc_animalType.nextLine();

                                System.out.println("Enter Animal Noise: ");
                                Scanner sc_animalNoise = new Scanner(System.in);
                                String animalNoise = sc_animalNoise.nextLine();

                                System.out.println("Enter Animal Description: ");
                                Scanner sc_animalDescription = new Scanner(System.in);
                                String animalDescription = sc_animalDescription.nextLine();

                                admin.addAnimal(animalName, animalType, animalNoise, animalDescription);
                            }

                            else if(animalQ == 2){
                                admin.viewAnimals();

                                System.out.println("Enter animal index: ");
                                Scanner sc_animalIndex = new Scanner(System.in);
                                int animalIndex = sc_animalIndex.nextInt();

                                System.out.println("Change Animal Description: ");
                                Scanner sc_animalDescription = new Scanner(System.in);
                                String animalDescription = sc_animalDescription.nextLine();

                                admin.updateAnimalDetails(animalIndex, animalDescription);
                            }

                            else if(animalQ == 3){
                                admin.viewAnimals();

                                System.out.println("Enter animal name: ");
                                Scanner sc_animalIndex = new Scanner(System.in);
                                int animalIndex = sc_animalIndex.nextInt();

                                admin.removeAnimal(animalIndex);
                            }

                            else if(animalQ == 4){
                                System.out.println("Exiting");
                            }
                        }

                        if(adminQ == 3){
                            System.out.println("Which attraction schedule do you want to edit: ");
                            admin.viewAttractions();

                            Scanner sc_attractionIndex = new Scanner(System.in);
                            int attractionIndex = sc_attractionIndex.nextInt();

                            System.out.println("1. Open attraction\n" +
                                    "2. Close attraction");

                            Scanner sc_schedule = new Scanner(System.in);
                            int schedule = sc_schedule.nextInt();

                            admin.schedule(attractionIndex, schedule);
                        }

                        if(adminQ == 4){
                            System.out.println("""
                                    Set Discounts:
                                    1. Add Discount
                                    2. Modify Discount
                                    3. Remove Discount
                                    4. Exit

                                    Enter your choice:
                                    """);

                            Scanner sc_discountQ = new Scanner(System.in);
                            int discountQ = sc_discountQ.nextInt();

                            if(discountQ == 1){
                                System.out.println("Enter Discount Category: ");
                                Scanner sc_discountCategory = new Scanner(System.in);
                                String discountCategory = sc_discountCategory.nextLine();

                                System.out.println("Enter Discount Percentage: ");
                                Scanner sc_discountPercentage = new Scanner(System.in);
                                int discountPercentage = sc_discountPercentage.nextInt();

                                System.out.println("Enter Discount Code: ");
                                Scanner sc_discountCode = new Scanner(System.in);
                                String discountCode = sc_discountCode.nextLine();


                                admin.addDiscount(discountCategory, discountPercentage, discountCode);
                            }

                            else if(discountQ == 2){
                                System.out.println("Enter Discount Category to be modified: ");
                                Scanner sc_discountCategory = new Scanner(System.in);
                                String discountCategory = sc_discountCategory.nextLine();

                                System.out.println("Enter new discount percentage: ");
                                Scanner sc_discountPercentage = new Scanner(System.in);
                                int discountPercentage = sc_discountPercentage.nextInt();

                                admin.modifyDiscount(discountCategory, discountPercentage);
                            }

                            else if(discountQ == 3){
                                System.out.println("Enter Discount Category to be removed: ");
                                Scanner sc_discountCategory = new Scanner(System.in);
                                String discountCategory = sc_discountCategory.nextLine();

                                admin.removeDiscount(discountCategory);
                            }

                            else if(discountQ == 4){
                                System.out.println("Exiting");
                            }

                        }

                        if(adminQ == 5){
                            System.out.println("Enter number of tickets for deal: ");
                            Scanner sc_dealNumTickets = new Scanner(System.in);
                            int dealNumTickets = sc_dealNumTickets.nextInt();

                            System.out.println("Enter discount percentage: ");
                            Scanner sc_dealDiscount = new Scanner(System.in);
                            int dealDiscount = sc_dealDiscount.nextInt();

                            if(admin.addDeal(dealNumTickets, dealDiscount)){
                                System.out.println("The deal has been set");
                            }

                            else{
                                System.out.println("There is already a deal for these number of tickets");
                            }
                        }

                        if(adminQ == 6){
                            //View Visitor Stats
                            System.out.println("Visitor Statistics:");
                            System.out.println("- Total Visitors: " + admin.totalVisitors());
                            System.out.println("- Total Revenue: $" + admin.totalRevenue());
                            System.out.println("- Most Popular Attraction: " + admin.mostPopularAttraction().getName());
                        }

                        if(adminQ == 7){
                            admin.viewFeedback();
                        }

                        if(adminQ == 8){
                            System.out.println("Logged out.");
                            break;
                        }
                    }
                } else {
                    System.out.println("Incorrect username or password.");
                }
            }

            else if(homeQuestion == 2){
                System.out.println("""
                        1. Register
                        2. Login

                        Enter your choice:
                        """);
                Scanner sc_visitorLoginQ = new Scanner(System.in);
                int visitorLoginQ = sc_visitorLoginQ.nextInt();

                if(visitorLoginQ == 1) {
                    Visitor visitor = new Visitor();

                    System.out.println("Enter Visitor Name: ");
                    Scanner sc_visitorName = new Scanner(System.in);
                    visitor.setName(sc_visitorName.nextLine());

                    System.out.println("Visitor Age: ");
                    Scanner sc_visitorAge = new Scanner(System.in);
                    visitor.setAge(sc_visitorAge.nextInt());

                    System.out.println("Visitor Phone Number: ");
                    Scanner sc_visitorPhoneNumber = new Scanner(System.in);
                    visitor.setPhoneNumber(sc_visitorPhoneNumber.nextLine());

                    System.out.println("Visitor Balance: ");
                    Scanner sc_visitorBalance = new Scanner(System.in);
                    visitor.setBalance(sc_visitorBalance.nextFloat());

                    System.out.println("Visitor Email: ");
                    Scanner sc_visitorEmail = new Scanner(System.in);
                    visitor.setEmail(sc_visitorEmail.nextLine());

                    System.out.println("Visitor Password: ");
                    Scanner sc_visitorPass = new Scanner(System.in);
                    visitor.setPassword(sc_visitorPass.nextLine());

                    System.out.println("Registration is successful.");

                    admin.addVisitor(visitor);
                }

                else if(visitorLoginQ == 2){
                    System.out.println("Enter Visitor Email: ");
                    Scanner sc_checkEmail = new Scanner(System.in);
                    String checkEmail = sc_checkEmail.nextLine();

                    System.out.println("Enter Visitor Password: ");
                    Scanner sc_checkPass = new Scanner(System.in);
                    String checkPass = sc_checkPass.nextLine();

                    if(admin.getVisitor(checkEmail, checkPass) != null){
                        Visitor visitor = admin.getVisitor(checkEmail, checkPass);

                        while(true){
                            System.out.println("""
                            Visitor Menu:
                            1. Explore the Zoo
                            2. Buy Membership
                            3. Buy Tickets
                            4. View Discounts
                            5. View Special Deals
                            6. Visit Animals
                            7. Visit Attractions
                            8. Leave Feedback
                            9. Log Out
                            """);

                            Scanner sc_visitorQ = new Scanner(System.in);
                            int visitorQ = sc_visitorQ.nextInt();

                            if(visitorQ == 1) {

                                while (true) {
                                    System.out.println("""
                                            Explore the Zoo:
                                            1. View Attractions
                                            2. View Animals
                                            3. Exit

                                            Enter your choice:
                                            """);
                                    Scanner sc_exploreQ = new Scanner(System.in);
                                    int exploreQ = sc_exploreQ.nextInt();

                                    if (exploreQ == 1) {
                                        visitor.viewAttractions(admin);
                                    } else if (exploreQ == 2) {
                                        visitor.viewAnimals(admin);
                                    } else {
                                        break;
                                    }
                                }
                            }

                            else if(visitorQ == 2){
                                System.out.println("""
                                        Buy Membership:
                                        1. Basic Membership (₹20)
                                        2. Premium Membership (₹50)
                                        Enter your choice:
                                        """);

                                Scanner sc_membershipQ = new Scanner(System.in);
                                int membershipQ = sc_membershipQ.nextInt();

                                System.out.println("Enter discount code or type NA: ");
                                Scanner sc_code = new Scanner(System.in);
                                String code = sc_code.nextLine();

                                if(membershipQ == 1){
                                    visitor.buyMembership(admin, "basic", code);
                                }

                                else if (membershipQ == 2){
                                    visitor.buyMembership(admin, "premium", code);
                                }

                                else{
                                    System.out.println("Enter valid input.");
                                }
                            }

                            else if (visitorQ == 3){
                                System.out.println("""
                                        Buy Tickets:
                                        Select an Attraction to Buy a Ticket:
                                        """);
                                visitor.viewAttractions(admin);
                                System.out.println("Enter your choice: ");

                                Scanner sc_ticketsQ = new Scanner(System.in);
                                int ticketsQ = sc_ticketsQ.nextInt();

                                System.out.println("Enter number of tickets: ");
                                Scanner sc_numTickets = new Scanner(System.in);
                                int numTickets = sc_numTickets.nextInt();

                                visitor.buyTicket(admin, ticketsQ, numTickets);
                            }

                            else if(visitorQ == 4){
                                visitor.viewDiscount(admin);
                            }

                            else if (visitorQ == 5) {
                                visitor.viewSpecialDeals(admin);
                            }

                            else if(visitorQ == 6){
                                visitor.viewAnimals(admin);
                                System.out.println("Which animal do you want to visit?");
                                Scanner sc_visitAnimal = new Scanner(System.in);
                                int visitAnimal = sc_visitAnimal.nextInt();

                                System.out.println("""
                                        What do you want to do:
                                        1. feed animal
                                        2. read description""");

                                Scanner sc_animalOption = new Scanner(System.in);
                                int animalOption = sc_animalOption.nextInt();

                                if(animalOption == 1){
                                    visitor.feedAnimal(admin, visitAnimal);
                                }

                                else if(animalOption == 2){
                                    visitor.readAnimalDetails(admin, visitAnimal);
                                }

                                else{
                                    System.out.println("Enter valid option.");
                                }
                            }

                            else if(visitorQ == 7){
                                System.out.println("Visit Attractions:\n" + "Select an Attraction to Visit:");
                                visitor.viewAttractions(admin);
                                System.out.println("Enter your choice: ");

                                Scanner sc_visitQ = new Scanner(System.in);
                                int visitQ = sc_visitQ.nextInt();

                                visitor.visitAttractions(admin, visitQ);
                            }

                            else if(visitorQ == 8){
                                System.out.println("Leave feedback (max 200 characters): ");
                                Scanner sc_feedback = new Scanner(System.in);
                                String feedback = sc_feedback.nextLine();
                                visitor.leaveFeedback(admin, feedback);
                            }

                            else if(visitorQ == 9){
                                break;
                            }
                        }

                    }

                    else{
                        System.out.println("Invalid Email or Password.");
                    }
                }

                else{
                    System.out.println("Enter valid option");
                }
            }

            else if(homeQuestion == 3){
                System.out.println("Thanks for visiting ZOOtopia. \nExiting...");
                break;
            }

            else{
                System.out.println("Enter valid option");
            }
        }
    }
}
