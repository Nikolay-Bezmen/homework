package edu.hw7.Task3_5;

import edu.hw7.Person;
import edu.hw7.PersonDataBaseInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PersonDataBase implements PersonDataBaseInterface {
    private final static Map<Integer, Person> ID_TO_PERSON = new HashMap<>();
    private final static Map<String, List<Person>> NAME_TO_LIST_PERSON = new HashMap<>();
    private final static Map<String, List<Person>> ADDRESS_TO_LIST_PERSON = new HashMap<>();
    private final static Map<String, List<Person>> PHONE_NUMBER_TO_LIST_PERSON = new HashMap<>();
    private final static ReadWriteLock LOCK = new ReentrantReadWriteLock();

    @Override
    public void add(Person person) {
        LOCK.writeLock().lock();
        try {
            if (person != null) {
                ID_TO_PERSON.put(person.id(), person);
                NAME_TO_LIST_PERSON.computeIfAbsent(person.name(), f -> new ArrayList<>()).add(person);
                ADDRESS_TO_LIST_PERSON.computeIfAbsent(person.address(), f -> new ArrayList<>()).add(person);
                PHONE_NUMBER_TO_LIST_PERSON.computeIfAbsent(person.phoneNumber(), f -> new ArrayList<>()).add(person);
            }
        } finally {
            LOCK.writeLock().unlock();
        }

    }

    @Override
    public void delete(int id) {
        LOCK.writeLock().lock();
        try {
            Person personForRemove = ID_TO_PERSON.remove(id);
            NAME_TO_LIST_PERSON.get(personForRemove.name()).remove(personForRemove);
            PHONE_NUMBER_TO_LIST_PERSON.get(personForRemove.phoneNumber()).remove(personForRemove);
            ADDRESS_TO_LIST_PERSON.get(personForRemove.address()).remove(personForRemove);
        } finally {
            LOCK.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        LOCK.readLock().lock();
        try {
            return new ArrayList<>(NAME_TO_LIST_PERSON.getOrDefault(name, new ArrayList<>()));
        } finally {
            LOCK.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        LOCK.readLock().lock();
        try {
            return new ArrayList<>(ADDRESS_TO_LIST_PERSON.getOrDefault(address, new ArrayList<>()));
        } finally {
            LOCK.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        LOCK.readLock().lock();
        try {
            return new ArrayList<>(PHONE_NUMBER_TO_LIST_PERSON.getOrDefault(phone, new ArrayList<>()));
        } finally {
            LOCK.readLock().unlock();
        }
    }
}
