package eu.epfc.c5900.contactooapp;

import java.util.List;

public interface IContactUI {
    void displayList(List<Contact> contacts);
    Contact displayForm();
    int askId();
}
