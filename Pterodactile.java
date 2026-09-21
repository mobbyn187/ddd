package course.java.pl.oop.trainer.animal;

public class Pterodactile extends Animal {

    private double wingSpan;

    public Pterodactile(String name, String species, double wingSpan) {
        super(name, species);
        this.wingSpan = wingSpan;
    }

    public double getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
    }

    @Override
    public String toString() {
        return getSpecies() + " " + wingSpan;
    }
}
