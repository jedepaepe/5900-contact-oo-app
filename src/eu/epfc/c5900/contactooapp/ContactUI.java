package eu.epfc.c5900.contactooapp;

import java.util.List;
import java.util.Scanner;

public class ContactUI implements IContactUI {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void displayList(List<Contact> contacts) {
        for(Contact c : contacts) {
            System.out.println(c.id + ", " + c.firstName + ", " + c.lastName + ", " + c.email + ", " + c.phone);
        }
    }

    @Override
    public Contact displayForm() {
        Contact contact = new Contact();
        System.out.print("prénom: ");
        contact.firstName = scanner.nextLine();
        System.out.print("nom: ");
        contact.lastName = scanner.nextLine();
        System.out.print("email: ");
        contact.email = scanner.nextLine();
        System.out.print("téléphone: ");
        contact.phone = scanner.nextLine();
        return contact;
    }

    @Override
    public int askId() {
        System.out.print("identificant: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }
}
