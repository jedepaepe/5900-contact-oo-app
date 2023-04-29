package eu.epfc.c5900.contactooapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ContactApp {
    private final IContactUI contactUI = new ContactUI();
    private final IContactDao contactDao = new ContactDao();

    public ContactApp() {
        initialize();
    }

    private void initialize() {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./contact")) {
            String sql = "CREATE TABLE IF NOT EXISTS Contact (" +
                    "Id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                    "FirstName VARCHAR(64) NOT NULL," +
                    "LastName VARCHAR(64) NOT NULL," +
                    "Email VARCHAR(128)," +
                    "PHONE VARCHAR(20)" +
                    ")";
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void run() {
        String choice;
        do {
            choice = contactUI.showMenu();
            switch (choice) {
                case "1" -> showContacts();
                case "2" -> addContact();
                case "3" -> updateContact();
                case "4" -> deleteContact();
            }
        } while(! choice.equals("S"));
    }

    private void deleteContact() {
        int id = contactUI.askId();
        contactDao.delete(id);
    }

    private void updateContact() {
        int id = contactUI.askId();
        Contact contact = contactUI.displayForm();
        contact.id = id;
        contactDao.update(contact);
    }

    private void addContact() {
        Contact contact = contactUI.displayForm();
        contactDao.add(contact);
    }

    private void showContacts() {
        // db
        List<Contact> contacts = contactDao.fetch();
        contactUI.displayList(contacts);
    }
}
