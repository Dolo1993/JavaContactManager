import java.util.ArrayList;
import java.util.Scanner;

// Class representing a contact
class Contact {
    private String name;
    private String phoneNumber;

    // Constructor to initialize contact with name and phone number
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getter method for the contact name
    public String getName() {
        return name;
    }

    // Getter method for the contact phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter method to update the contact phone number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

// Main class for the Contact Manager application
public class ContactManager {
    private ArrayList<Contact> contacts; // ArrayList to store contacts
    private Scanner scanner; // Scanner for user input

    // Constructor to initialize ContactManager with an empty list of contacts
    public ContactManager() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Display the main menu options
    public void displayMenu() {
        System.out.println("\n1. Add Contact");
        System.out.println("2. Edit Contact");
        System.out.println("3. Delete Contact");
        System.out.println("4. Search Contact");
        System.out.println("5. Display All Contacts");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method to add a new contact to the list
    public void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        // Create a new Contact object and add it to the ArrayList
        Contact newContact = new Contact(name, phoneNumber);
        contacts.add(newContact);

        System.out.println("Contact added successfully!");
    }

    // Method to edit a contact in the list
    public void editContact() {
        System.out.print("Enter name to edit: ");
        String editName = scanner.nextLine();

        // Iterate through the contacts to find a matching name for editing
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(editName)) {
                System.out.print("Enter new phone number: ");
                String newPhoneNumber = scanner.nextLine();
                contact.setPhoneNumber(newPhoneNumber);
                System.out.println("Contact edited successfully!");
                return;
            }
        }

        System.out.println("Contact not found for editing!");
    }

    // Method to delete a contact from the list
    public void deleteContact() {
        System.out.print("Enter name to delete: ");
        String deleteName = scanner.nextLine();

        // Iterate through the contacts to find a matching name for deletion
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(deleteName)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully!");
                return;
            }
        }

        System.out.println("Contact not found for deletion!");
    }

    // Method to search for a contact by name
    public void searchContact() {
        System.out.print("Enter name to search: ");
        String searchName = scanner.nextLine();

        // Iterate through the contacts to find a matching name
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Contact found: " + contact.getName() + " - " + contact.getPhoneNumber());
                return;
            }
        }

        System.out.println("Contact not found!");
    }

    // Method to display all contacts in the list
    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            System.out.println("All Contacts:");
            for (Contact contact : contacts) {
                System.out.println(contact.getName() + " - " + contact.getPhoneNumber());
            }
        }
    }

    // ...

// Main method to run the Contact Manager application
public static void main(String[] args) {
    ContactManager contactManager = new ContactManager();
    int choice = 0; // Initialize the choice variable

    // Main loop to display the menu and handle user input
    do {
        contactManager.displayMenu();

        // Handle invalid input with a try-catch block
        try {
            choice = Integer.parseInt(contactManager.scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            continue;
        }

        // Switch statement to perform actions based on user's choice
        switch (choice) {
            case 1:
                contactManager.addContact();
                break;
            case 2:
                contactManager.editContact();
                break;
            case 3:
                contactManager.deleteContact();
                break;
            case 4:
                contactManager.searchContact();
                break;
            case 5:
                contactManager.displayAllContacts();
                break;
            case 6:
                System.out.println("Exiting Contact Manager. Goodbye!"); 
                 System.out.println(""); 
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }

    } while (choice != 6);

    // Close scanner to avoid resource leak
    contactManager.scanner.close();
}
}