package eu.epfc.c5900.contactooapp;

public class ContactApp {
    private final IContactUI contactUI = new ContactUI();

    public void run() {
        Contact contact = contactUI.displayForm();
    }
}
