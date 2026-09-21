package course.java.pl.oop.trainer.animal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
            STWORZYC DIAGRAM UML!!!!

         * W systemie przechowujemy informacje o zwierzetach (nazwa, gatunek). Dla psów
         * przechowujemy dodatkowe ich dlugosc siersci oraz ulubione zabawki ,dla kotów
         * stopien bycia wkurwiajacym futrzakiem (1-10) oraz dla pterodaktylow
         * rozpietosc skrzydel.

         *
         * Trenerzy (imie, nazwisko, adres) trenuja zwierzeta. Kazdy trener trenuje
         * wiele zwierzat, ale zwierze jest pod okiem jednego trenera.
         *
         * Trener uzywa Sprzetu (nazwa, stopien zuzycia(nowe, uzywane, tragiczne)),
         * sprzet moze byc naprawiany. Chcemy przechowywac informacje o tym jaki trener
         * uzywal kiedy jkaiego sprzetu. Sprzet przez trenera moze byc uzywany
         * wielokrotnie.
         *
         *
         * -znajdz trenera ktory trenował najwiecej zwierzat
         * -znajdz trenera ktory uzywał jakiegos sprzetu najwieksza liczbe razy
         * -znajdz trenerow ktorzy trenowali psy z gatunku spaniel
         * -znajdz wszystkie sprzety które byly naprawiane co najmniej 2 razy
         * -znajdz wszystkie pterodaktyle ktore nigdy nie mialy przypisanego trenera
         */
        Animal cat1 = new Cat("Gucio", "Maine coon", 5);
        Animal cat2 = new Cat("Franek", "Pers", 7);
        Animal dog1 = new Dog("Rico", "spaniel", 3.2);
        Animal dog2 = new Dog("Ozi", "Cane corso", 0.5);
        Trainer igor = new Trainer("Igor", "Krasowski", "graniczna 1");
        Trainer jan = new Trainer("Jan", "Bratus", "Przyszlosci 38");
        igor.addAnimal(cat1);
        igor.addAnimal(dog1);
        System.out.println(igor.getAnimals());
        jan.addAnimal(cat2);
        System.out.println(jan.getAnimals());
        List<Trainer> trainers = new ArrayList<>(Arrays.asList(jan, igor));
        System.out.println(TrainerService.findTheMostCountOfAnimals(trainers));
        Equipment hantle20kg = new Equipment("hantle 20", "Nowe");
        Equipment hantle30kg = new Equipment("hantle 30", "Uzywane");
        Equipment hantle40kg = new Equipment("hantle 40", "Tragiczne");

        jan.useEquipment(hantle20kg);
        jan.useEquipment(hantle20kg);
        igor.useEquipment(hantle20kg);
        igor.useEquipment(hantle20kg);
        Animal dog3 = new Dog("Zoya", "spaniel", 1.0);
        jan.addAnimal(dog3);
        List<Equipment> equipments = new ArrayList<>(Arrays.asList(hantle20kg, hantle30kg, hantle40kg));
        hantle40kg.repair();
        hantle40kg.repair();

        System.out.println(TrainerService.findTrainerWhoUseTheMostOftenEquipment(hantle20kg, trainers));
        System.out.println(TrainerService.findTrainersWhoTrainedProvidedSpecies1(trainers, "Maine coon"));
        System.out.println(TrainerService.returnEquipmentsWithRepairsXTimes(equipments,2));


    }
}
