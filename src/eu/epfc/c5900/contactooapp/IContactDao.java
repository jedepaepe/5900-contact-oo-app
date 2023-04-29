package eu.epfc.c5900.contactooapp;

import java.util.List;

public interface IContactDao {
    List<Contact> fetch();
    void add(Contact contact);
    void update(Contact contact);
    void delete(int id);
}
