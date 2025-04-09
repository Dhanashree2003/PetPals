package Main;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import Dao.*;
import Exception.*;
import Model.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PetDao petDao = new PetDaoImpl();
        DonationDao donationDao = new DonationDaoImpl();
        AdoptionEventDao eventDao = new AdoptionEventDaoImpl();
        ParticipantDao participantDao = new ParticipantDaoImpl();

        while (true) {
            System.out.println("\n==== PetPals Adoption Platform ====");
            System.out.println("1. Add Pet");
            System.out.println("2. Remove Pet by ID");
            System.out.println("3. View Available Pets");
            System.out.println("4. Make Cash Donation");
            System.out.println("5. Host Event (Add New Event)");
            System.out.println("6. Register Participant (Add Participant)");
            System.out.println("7. List Participants of Event");
            System.out.println("8. List All Events");
            System.out.println("9. List All Donations");
   
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Pet ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        if (age <= 0) throw new InvalidPetAgeException("Pet age must be positive.");
                        System.out.print("Breed: ");
                        String breed = sc.nextLine();
                        System.out.print("Is available (true/false): ");
                        boolean available = sc.nextBoolean();
                        Pet pet = new Pet(id, name, age, breed, available);
                        petDao.addPet(pet);
                        
                        break;

                    case 2:
                    	 System.out.print("Enter Pet ID to remove: ");
                         int removeId = sc.nextInt();
                         sc.nextLine();
                         petDao.removePet(removeId);
                         
                         break;
                    	

                    case 3:
                        List<Pet> pets = petDao.listAvailablePets();
                        pets.forEach(System.out::println);
                        System.out.println("All Pets Listed Successfully!");
                        break;
                    	
                        

                    case 4:
                        System.out.print("Donor Name: ");
                        String donor = sc.nextLine();

                        System.out.print("Donation Type (cash/item): ");
                        String typeInput = sc.nextLine().trim().toUpperCase();
                        DonationType type = DonationType.valueOf(typeInput);

                        double amount = 0;
                        String item = null;

                        if (type == DonationType.CASH) {
                            System.out.print("Amount: ");
                            amount = sc.nextDouble();
                            sc.nextLine();
                            if (amount < 10)
                                throw new InsufficientFundsException("Minimum donation is $10");
                        } else {
                            System.out.print("Item Type: ");
                            item = sc.nextLine();
                        }

                        Donation donation = new Donation(donor, type, amount, item, LocalDateTime.now());
                        donationDao.recordDonation(donation);
                        break;       

                    case 5:
                    	System.out.print("Event Name: ");
                        String event = sc.nextLine();
                        AdoptionEvent ae = new AdoptionEvent(event);
                        eventDao.createEvent(ae);  
                        break;
                    	
                        

                    case 6:
                    	System.out.print("Participant Name: ");
                        String pname = sc.nextLine();
                        System.out.print("Type (shelter/adopter): ");
                        String ptype = sc.nextLine();
                        System.out.print("Event ID to register for: ");
                        int eid = sc.nextInt();
                        sc.nextLine();
                        Participant participant = new Participant(pname, ptype);
                        participantDao.addParticipant(participant, eid);    
                        break;
                    	
                        

                    case 7:
                    	System.out.print("Enter Event ID to view participants: ");
                        int eventId = sc.nextInt();
                        sc.nextLine();
                        List<Participant> plist = participantDao.listParticipantsByEvent(eventId);
                        plist.forEach(System.out::println);
                        System.out.println("All Participants listed Successfully!");
                        break;
   

                    case 8:
                    	List<AdoptionEvent> events = eventDao.listEvents();
                        events.forEach(System.out::println);
                        System.out.println("All Events listed Successfully!");
                        break;
           

                    case 9:
                    	List<Donation> donations = donationDao.listDonations();
                        donations.forEach(System.out::println);
                        System.out.println("All Donations listed Successfully!");
                        break;

                    case 0:
                        System.out.println("Thank you for using PetPals!");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
