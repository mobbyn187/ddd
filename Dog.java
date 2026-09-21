package course.java.pl.oop.trainer.animal;
import java.util.*;

public class Dog extends Animal {

    private double furLength;
    private List<String> favToys = new ArrayList<>();

    public Dog(String name, String species, double furLength) {
        super(name, species);
        this.furLength = furLength;
    }
    public void addToy(String toy) {
        if (toy == null) {
            throw new IllegalArgumentException("Toy cannot be null!");
        }
        if (favToys.contains(toy)) {
            throw new IllegalArgumentException("This dog already have this toy in his fav toys!");
        }
        favToys.add(toy);
    }
    public void removeToy(String toy) {
        if (!favToys.contains(toy)) {
            throw new IllegalArgumentException("this toy doesn't belongs to list of fav toys this dog!");
        }
        favToys.remove(toy);
    }

    public double getFurLength() {
        return furLength;
    }

    public void setFurLength(double furLength) {
        this.furLength = furLength;
    }

    public List<String> getFavToys() {
        return favToys;
    }

    public void setFavToys(List<String> favToys) {
        this.favToys = favToys;
    }

    @Override
    public String toString() {
        return getSpecies() + " fur length: " + furLength + " favourite toys: " + favToys;
    }
}
