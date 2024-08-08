package service;

import model.FamilyTree;
import model.Person;

import java.io.*;

public class FileHandler {

    public void saveToFile(FamilyTree<Person> familyTree, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(familyTree);
        }
    }

    @SuppressWarnings("unchecked")
    public FamilyTree<Person> loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FamilyTree<Person>) ois.readObject();
        }
    }
}
