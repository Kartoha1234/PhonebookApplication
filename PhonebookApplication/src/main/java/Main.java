import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ActionWithContact action = new ActionWithContact();
        String comand = "";
        Scanner scanner = new Scanner(System.in);
        while (!comand.equals("exit")){
            System.out.println("\r\n\r\n" +
                    "Enter \"add\" to add contact to list \r\n" +
                    "Enter \"remove\" to remove contact from list \r\n" +
                    "Enter \"read\" to read all contacts from list \r\n" +
                    "Enter \"search\" to search contact in the list \r\n" +
                    "Enter \"exit\" to exit \r\n");
            comand = scanner.nextLine();
            switch (comand){
                case "add":{
                    System.out.println("Please type the name of contact: ");
                    String contactName = scanner.nextLine();
                    System.out.println("Please type the number of contact: ");
                    String number = scanner.nextLine();
                    action.addContact(contactName,number);
                    break;}
                case "remove":{
                    System.out.println("Please type the Id of contact");
                    int Id = Integer.parseInt(scanner.nextLine());
                    action.removeContact(Id);
                    break;}
                case "read":{
                    var contacts = action.readContacts();
                    for (Contact contact : contacts){
                        System.out.println("Id: " + contact.getId() + " | Name: " + contact.getName() + " | Number: " + contact.getNumber());
                    }
                    break;}
                case "search":{
                    System.out.println("Please type the name of contact");
                    String contactName = scanner.nextLine();
                    Contact result = action.searchContact(contactName);
                    System.out.println("Сontact is found: " + "\r\n" + result.getNumber());
                    break;}
            }
        }
    }
}
