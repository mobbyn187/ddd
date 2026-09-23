package course.java.pl.oop.trainer.animal;

import java.util.*;
import java.util.ArrayList;

public class TrainerService {
    List<Trainer> trainers = new ArrayList<>();
    List<Equipment> equipments = new ArrayList<>();

    public TrainerService() {
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    private void addTrainer(Trainer trainer) {
        if (trainer == null) {
            throw new IllegalArgumentException("trainer cannot be null!");
        }
        if (trainers.contains(trainer)) {
            throw new IllegalArgumentException("this trainer already exists!");
        }
        trainers.add(trainer);
    }

    public void removeTrainer(Trainer trainer) {
        if (!trainers.contains(trainer)) {
            throw new IllegalArgumentException("this trainer doesn't exists!");
        }
        trainers.remove(trainer);
    }

    public void addEq(Equipment equipment) {
        if (equipment == null) {
            throw new IllegalArgumentException("equipment cannot be null!");
        }
        if (equipments.contains(equipment)) {
            throw new IllegalArgumentException("this equipment already exist!");
        }
        equipments.add(equipment);
    }

    public void removeEq(Equipment equipment) {
        if (!equipments.contains(equipment)) {
            throw new IllegalArgumentException("this equipment doesn't exists!");
        }
        equipments.remove(equipment);
    }

    //lepsza nazwa findTrainerWithMostAnimals - obecna nie do konca wskazuje ze metoda zwraca trenera
    public static Trainer findTheMostCountOfAnimals(List<Trainer> trainers) {

        if (trainers == null || trainers.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null!");
        }

        Trainer result = trainers.getFirst();

        for (Trainer trainer : trainers) {
            if (result.getAnimals().size() < trainer.getAnimals().size()) {
                result = trainer;
            }
        }
        return result;
    }

    /* czy equipment powinien byc parametrem tej metody? z tresci rozumiem, ze mamy znalezc trenera z najwieksza liczba
       sprzetu ogolnie, natomiast obecna implementacja znajduje trenera, ktory najczesciej uzywal konkretnego sprzetu
     */
    public static Trainer findTrainerWhoUseTheMostOftenEquipment(Equipment equipment, List<Trainer> trainers) {

        if (trainers == null || trainers.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null!");
        }

        Trainer result = trainers.getFirst();
        int help = 0;
        for (Trainer trainer : trainers) {
            int count = 0;
            for (EquipmentUsage usage : trainer.getEquipmentUsages()) {
                if (usage.wasUsed(trainer, equipment)) {
                    count++;
                }
            }
            if (help < count) {
                help = count;
                result = trainer;
            }
        }
        if (help == 0) {
            throw new IllegalArgumentException("no trainers were using it!");
        }
        return result;
    }

    // Z treści zadania wynika, że szukamy trenerów, którzy trenowali psy z gatunku spaniel.
    // Tutaj sprawdzamy jedynie wartość species, więc teoretycznie również inny typ zwierzęcia
    // z species = "spaniel" zostałby uwzględniony. Warto wykorzystać istniejący model klas i dodatkowo upewnić się,
    // że sprawdzane zwierzę jest psem:)
    public static List<Trainer> findTrainersWhoTrainedProvidedSpecies1(List<Trainer> trainers, String species) {

        if (trainers == null || trainers.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty!");
        }
        if (species == null || species.isBlank()) {
            throw new IllegalArgumentException("species cannot be empty!");
        }
        List<Trainer> result = new ArrayList<>();
        String speciesHelp = species.toLowerCase().trim().replace(" ", "");

        for (Trainer trainer : trainers) {
            for (Animal animal : trainer.getAnimals()) {
                if (animal.getSpecies().toLowerCase().trim().replace(" ", "").equals(speciesHelp)) {
                    result.add(trainer);
                    break;
                }
            }
        }
        return result;
    }

    public static List<Equipment> returnEquipmentsWithRepairsXTimes(List<Equipment> equipments, int countRepairs) {

        if (equipments == null || equipments.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty!");
        }

        if (countRepairs < 0) {
            throw new IllegalArgumentException("countRepairs cannot be negative!");
        }

        List<Equipment> result = new ArrayList<>();

        for (Equipment equipment : equipments) {
            if (equipment.getRepairCount() >= countRepairs) {
                result.add(equipment);
            }
        }
        return result;
    }

    // Tutaj sprawdzamy tylko, czy pterodaktyl aktualnie nie ma przypisanego trenera,
    // natomiast z treści zadania wynika, że powinniśmy znaleźć takie, które nigdy wcześniej nie miały trenera.
    // W obecnym rozwiązaniu, jeśli najpierw przypiszemy zwierzę do trenera, a później je usuniemy, trainer ponownie będzie null
    // i takie zwierzę zostanie błędnie zwrócone przez tę metodę.
    // Wydaje mi się, że warto rozszerzyć model Animal o informację pozwalającą określić, czy zwierzę kiedykolwiek miało przypisanego trenera (ewentualnie przechowywać historię takich przypisań).
    // Ta informacja powinna być aktualizowana w momencie przypisywania trenera. Wtedy tutaj moglibyśmy sprawdzać nie tylko aktualnego trainer, ale rzeczywiście warunek „nigdy nie miał trenera”.
    // Dodatkowo, skoro mamy osobną klasę Pterodactile, można wykorzystać typ zwierzęcia zamiast przekazywać jego gatunek jako String
    public static List<Animal> returnAnimalsWhichDoesNotHasATrainer(List<Animal> animals, String species) {

        if (animals == null || animals.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty!");
        }

        if (species == null || species.isBlank()) {
            throw new IllegalArgumentException("Species cannot be empty!");
        }

        List<Animal> result = new ArrayList<>();
        String speciesHelp = species.toLowerCase().trim().replace(" ", "");
        for (Animal animal : animals) {
            if (animal.getSpecies().toLowerCase().trim().replace(" ", "").equals(speciesHelp) && animal.getTrainer() == null) {
                result.add(animal);
            }
        }
        return result;
    }

    /// /  to do poprawy
//    public static List<Trainer> findTrainersWhoTrainedProvidedSpecies(List<Trainer> trainers,String species) {
//        List<Trainer> result = new ArrayList<>();
//
//        if (species == null || species.isBlank()) {
//            throw new IllegalArgumentException("species cannot be null!");
//        }
//        if (trainers == null || trainers.isEmpty()) {
//            throw new IllegalArgumentException("List cannot be null!");
//        }
//
//        for (Trainer trainer : trainers) {
//            for (Animal animal : trainer.getAnimals()) {
//                if (animal.getSpecies().equals(species)) {
//                    result.add(trainer);
//                    break;
//                }
//            }
//        }
//        return result;
//
//    }
    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    @Override
    public String toString() {
        return "TrainerService{" +
                "trainers=" + trainers +
                ", equipments=" + equipments +
                '}';
    }
}
