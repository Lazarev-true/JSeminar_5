import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Map<String, List<String>> phonBook = new HashMap<>();
        phonBook.put("Sonya", List.of("8(953) 777-77-77", "8(999) 999-99-99"));
        phonBook.put("Pahsa", List.of("8(953) 77-77-70", "8(955) 555-55-77", "8(800) 555-35-33"));
        phonBook.put("Nastya", List.of("8(953) 777-77-71", "8(999) 888-55-33", "8(933) 333-33-33"));
        phonBook.put("Sergey", List.of("8(953) 777-77-72", "8(900) 000-00-11"));
        phonBook.put("Olga", List.of("8(953) 777-77-73"));

        menu(phonBook);
    }

    public static String SC() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        // scanner.close();
        return scan;
    }

    public static void sortBook(Map<String, List<String>> phonBook) {
        Map<Integer, Map<String, List<String>>> sortByCount = new HashMap<>();
        for (String name : phonBook.keySet()) {
            if (!sortByCount.containsKey(phonBook.get(name).size())) {
                Map<String, List<String>> data = new HashMap<>();
                data.put(name, phonBook.get(name));
                sortByCount.put(phonBook.get(name).size(), data);
            } 
            else {
                Map<String, List<String>> data = sortByCount.get(phonBook.get(name).size());
                data.put(name, phonBook.get(name));
                sortByCount.put(phonBook.get(name).size(), data);
            }
        }
        System.out.println(sortByCount);
    }

    public static void find(Map<String, List<String>> phonBook) {
        System.out.println("Введите имя: ");
        String name = SC();
        System.out.println(phonBook.get(name));
    }

    public static void allBook(Map<String, List<String>> phonBook) {
        System.out.println(phonBook);
    }

    public static Map<String, List<String>> menu(Map<String, List<String>> phonBook) {
        System.out.println(
                "Введите команду из списка: \n* - найти контакт \n# - показать всю телефонную книгу \ns - сортировка по колличеству телефонов \n0 - выйти");
        while (true) {
            String comands = SC();
            if (comands.equals("0")) {
                break;
            } else {
                switch (comands) {
                    case "*":
                        find(phonBook);
                        break;
                    case "#":
                        allBook(phonBook);
                        break;
                    case "s":
                        sortBook(phonBook);
                        break;
                    default:
                        break;
                }
            }
        }
        return phonBook;
    }
}