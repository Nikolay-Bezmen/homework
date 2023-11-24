package edu.hw7.Task3;

import edu.hw7.Person;
import edu.hw7.PersonDataBaseInterFace;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonDataBase implements PersonDataBaseInterFace {
    private final static Map<Integer, Person> ID_TO_PERSON = new HashMap<>();
    private final static Map<String, List<Person>> NAME_TO_LIST_PERSON = new HashMap<>();
    private final static Map<String, List<Person>> ADDRESS_TO_LIST_PERSON = new HashMap<>();
    private final static Map<String, List<Person>> PHONE_NUMBER_TO_LIST_PERSON = new HashMap<>();

    @Override
    public synchronized void add(Person person) {
        if (person != null) {
            ID_TO_PERSON.put(person.id(), person);
            NAME_TO_LIST_PERSON.computeIfAbsent(person.name(), f -> new ArrayList<>()).add(person);
            ADDRESS_TO_LIST_PERSON.computeIfAbsent(person.address(), f -> new ArrayList<>()).add(person);
            PHONE_NUMBER_TO_LIST_PERSON.computeIfAbsent(person.phoneNumber(), f -> new ArrayList<>()).add(person);
        }
    }

    @Override
    public synchronized void delete(int id) {
        Person personForRemove = ID_TO_PERSON.remove(id);
        NAME_TO_LIST_PERSON.get(personForRemove.name()).remove(personForRemove);
        PHONE_NUMBER_TO_LIST_PERSON.get(personForRemove.phoneNumber()).remove(personForRemove);
        ADDRESS_TO_LIST_PERSON.get(personForRemove.address()).remove(personForRemove);
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        return new ArrayList<>(NAME_TO_LIST_PERSON.getOrDefault(name, new ArrayList<>()));
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        return new ArrayList<>(ADDRESS_TO_LIST_PERSON.getOrDefault(address, new ArrayList<>()));
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        return new ArrayList<>(PHONE_NUMBER_TO_LIST_PERSON.getOrDefault(phone, new ArrayList<>()));
    }
}
