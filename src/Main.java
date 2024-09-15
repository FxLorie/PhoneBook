public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPhone("Masha", 123456);
        System.out.println(phoneBook.getNumber("Masha"));
        phoneBook.addPhone("Masha", 654321);
        System.out.println(phoneBook.getNumber("Masha"));
        phoneBook.addPhone("Sasha", 321654);

        System.out.println("======");
        System.out.println(phoneBook.toString());

        System.out.println("======");
        phoneBook.removeNumber(123456);
        System.out.println(phoneBook);

        System.out.println("======");
        phoneBook.removeContact("Sasha");
        phoneBook.addPhone("Masha", 564584);
        System.out.println(phoneBook);
    }
}