import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ActionWithContact {
    public ArrayList<Contact> readContacts(){
        ArrayList<Contact>contacts = new ArrayList<Contact>();
        try {
            Scanner sc = new Scanner(new File("Contacts.csv"));
            sc.useDelimiter(",");
            sc.nextLine();
            while (sc.hasNextLine())
            {
                contacts.add(getDataFromLine(sc.nextLine()));
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return contacts;
    }

    private Contact getDataFromLine(String line){
        int id;
        String name;
        String number;
        Contact result = null;
        try {
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(",");
            id = lineScanner.nextInt();
            name = lineScanner.next();
            number = lineScanner.nextLine();
            result = new Contact(id,name,number);
        }catch (Exception e){

        }
        return result;
    }

    public void writeContacts(ArrayList<Contact> contacts) {
        try (PrintWriter writer = new PrintWriter("Contacts.csv")) {

            StringBuilder sb = new StringBuilder();
            sb.append("Id,");
            sb.append("Name,");
            sb.append("Number \r\n");
            for (Contact contact : contacts) {
                sb.append(contact.getId());
                sb.append(',');
                sb.append(contact.getName());
                sb.append(",");
                sb.append(contact.getNumber());
                sb.append("\r\n");
            }
            writer.write(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public void addContact( String contactName,String number){
        var typecontact = readContacts();
            int newId = typecontact.get(typecontact.size() - 1).getId() + 1;
            String newName = contactName;
            String newNumber = number;
            typecontact.add(new Contact(newId,newName,newNumber));
           writeContacts(typecontact);
    }

    public void removeContact(int Id){
        var remContact = readContacts();
        remContact.removeIf(contact -> contact.getId() == Id);
        writeContacts(remContact);
    }

    public Contact searchContact(String contactName){
        var contacts = readContacts();
        Contact foundContact = null;
        for (Contact contact : contacts){
            if (contact.getName().equals(contactName)){
                foundContact = contact;
            }
        }
        return foundContact;
    }
}


