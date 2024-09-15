import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    HashMap<String, List<Integer>> phoneBook = new HashMap<>();

    public void addPhone(String name, int number) {
        List<Integer> numbers;
        if (phoneBook.isEmpty() || !phoneBook.containsKey(name)) {
            numbers = new ArrayList<>();
        } else {
            numbers = phoneBook.get(name);
        }
        numbers.add(number);
        Collections.sort(numbers);
        phoneBook.put(name, numbers);
    }

    public String removeNumber(int number) {
        StringBuilder sb = new StringBuilder();
        if (phoneBook.isEmpty()) {
            sb.append("Книга пуста");
        } else {
            for (String name : phoneBook.keySet()) {
                for (Integer phone : phoneBook.get(name)) {
                    if (phone == number) {
                        List<Integer> numbers = phoneBook.get(name);
                        numbers.remove(phone);
                        if (phoneBook.get(name).isEmpty()) {
                            phoneBook.remove(name);
                            sb.append("Контакт ").append(name).append(" удален");
                        } else {
                            sb.append("Номер контакта").append(name).append(" удален");
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    public String removeContact(String name) {
        StringBuilder sb = new StringBuilder();
        if (phoneBook.isEmpty()) {
            sb.append("Книга пуста");
        } else if (!phoneBook.containsKey(name)) {
            sb.append("Контакта ").append(name).append(" не существует");
        } else {
            phoneBook.remove(name);
            sb.append("Контакт ").append(name).append(" удален");
        }
        return sb.toString();
    }

    public String getNumber(String name) {
        StringBuilder sb = new StringBuilder();
        if (phoneBook.isEmpty() || !phoneBook.containsKey(name)) {
            sb.append("Контакта ").append(name).append(" не существует");
        } else {
            sb.append(name).append(":");
            for (int phone : phoneBook.get(name)) {
                sb.append(" ").append(phone).append(",");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (phoneBook.isEmpty()) {
            sb.append("Книга пуста");
        } else {
            for (String name : phoneBook.keySet()) {
                sb.append(name).append(":");
                for (int phone : phoneBook.get(name)) {
                    sb.append(" ").append(phone).append(",");
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
