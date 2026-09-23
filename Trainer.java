package course.java.pl.oop.trainer.animal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private String surname;
    private String address;
    private List<Animal> animals = new ArrayList<>();
    private List<EquipmentUsage> equipmentUsages = new ArrayList<>();

    public Trainer(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public void addAnimal(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("Animal cannot be null!");
        }
        if (animal.getTrainer() != null) {
            throw new IllegalArgumentException("This animal already belongs to a trainer!");
        }
        animals.add(animal);
        animal.setTrainer(this);
    }

    //Sprawdzamy tutaj tylko, czy zwierzę ma przypisanego jakiegokolwiek trenera.
    // Czy nie powinniśmy dodatkowo sprawdzić, czy animal.getTrainer() == this?
    // W obecnej implementacji jeden trener może wywołać removeAnimal() dla
    // zwierzęcia należącego do innego trenera i ustawić mu trainer = null
    public void removeAnimal(Animal animal) {
        if (animal.getTrainer() == null) {
            throw new IllegalArgumentException("this animal doesn't belong to a trainer!");
        }
        animals.remove(animal);
        animal.setTrainer(null);
    }

    // Może warto zwalidować equipment przed utworzeniem EquipmentUsage?
    // Obecnie useEquipment(null) utworzy wpis historii bez sprzętu
    public void useEquipment(Equipment equipment) {
        EquipmentUsage usage = new EquipmentUsage(this, equipment, LocalDate.now());
        equipmentUsages.add(usage);
    }
    // Czy to jest potrzebne, skoro mamy useEquipment()?
    // Pozwala obecnie dodać trenerowi EquipmentUsage wskazujące na innego trenera,
    // więc kolekcja może stać się niespójna
    public void addEquipmentUsage(EquipmentUsage usage) {
        equipmentUsages.add(usage);
    }

    public List<EquipmentUsage> getEquipmentUsages() {
        return equipmentUsages;
    }

    public void setEquipmentUsages(List<EquipmentUsage> equipmentUsages) {
        this.equipmentUsages = equipmentUsages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
