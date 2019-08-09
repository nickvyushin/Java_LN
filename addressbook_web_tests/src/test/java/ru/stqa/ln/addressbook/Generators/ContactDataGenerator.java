package ru.stqa.ln.addressbook.Generators;

import ru.stqa.ln.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<ContactData> contacts = generateContacts(count);
        save(contacts, file);
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData().withFirstName(String.format("Ivan"))
                    .withLastName(String.format("Ivanov")).withAddress(String.format("Akademiks Koroleva %s", i)).withMobilePhone(String.format("1234 %s", i)).withEmail(String.format("test" + i + "@tect.ts")));
        }
        return contacts;
    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts) {
            writer.write(String.format("%s;%s;%s;%s;%S\n",
                    contact.getFirstName(), contact.getLastName(), contact.getAddress(), contact.getMobilePhone(), contact.getEmail()));
        }
        writer.close();
    }
}
