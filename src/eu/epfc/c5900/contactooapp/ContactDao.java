package eu.epfc.c5900.contactooapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDao implements IContactDao {
    @Override
    public List<Contact> fetch() {
        List<Contact> contacts = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./contact")) {
            String sql = "SELECT Id, FirstName, LastName, Email, Phone FROM Contact";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Contact contact = new Contact();
                contact.id = resultSet.getInt("Id");
                contact.firstName = resultSet.getString("Firstname");
                contact.lastName = resultSet.getString("LastName");
                contact.email = resultSet.getString("Email");
                contact.phone = resultSet.getString("Phone");
                contacts.add(contact);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }

    @Override
    public void add(Contact contact) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./contact")) {
            String sql = "INSERT INTO Contact (FirstName, LastName, Email, Phone) VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, contact.firstName);
            statement.setString(2, contact.lastName);
            statement.setString(3, contact.email);
            statement.setString(4, contact.phone);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Contact contact) {

    }

    @Override
    public void delete(int id) {

    }
}
