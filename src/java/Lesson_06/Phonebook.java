import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    private Map<String, List<String>> directory;

    public Phonebook() {
        directory = new HashMap<>();
    }
    public void add(String surname, String phoneNumber) {
        directory.putIfAbsent(surname, new ArrayList<>());
        directory.get(surname).add(phoneNumber);
    }
    public List<String> get(String surname) {
        return directory.getOrDefault(surname, new ArrayList<>());
    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Иванов", "+7-999-111-11-11");
        phonebook.add("Петров", "+7-999-222-22-22");
        phonebook.add("Иванов", "+7-999-333-33-33");
        System.out.println("Телефоны Иванова: " + phonebook.get("Иванов"));
        System.out.println("Телефоны Петрова: " + phonebook.get("Петров"));
        System.out.println("Телефоны Сидорова: " + phonebook.get("Сидоров")); // Такого нет, вернет []
    }
}