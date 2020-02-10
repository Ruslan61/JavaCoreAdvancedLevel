package lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    void add (String name, String tel){
        ArrayList<String> telList = phoneBook.get(name);
        if(telList == null) telList = new ArrayList<>();
        telList.add(tel);
        phoneBook.put(name, telList);
    }

    ArrayList<String> get(String name){
        return phoneBook.get(name);
    }

    public static void main(String[] args) {

    PhoneBook phoneBook = new PhoneBook();

    phoneBook.add("Ivanov", "89629991919");
    phoneBook.add("Petrov", "89628881818");
    phoneBook.add("Sidorov", "89627771717");
    phoneBook.add("Ivanov", "89626661616");
    phoneBook.add("Petrov", "89625551515");

        System.out.println("Ivanov phone number " + phoneBook.get("Ivanov"));
        System.out.println("Petrov phone number " + phoneBook.get("Petrov"));
        System.out.println("Sidorov phone number " + phoneBook.get("Sidorov"));

    }
}
