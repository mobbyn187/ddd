package course.java.pl.oop.trainer.animal;

public class Cat extends Animal {

    private int annoyingLevel;

    public Cat(String name, String species, int annoyingLevel) {
        super(name, species);
        if (annoyingLevel < 1 || annoyingLevel > 10) {
            throw new IllegalArgumentException("annoying level can be only in scale 1-10");
        }
        this.annoyingLevel = annoyingLevel;
    }

    public int getAnnoyingLevel() {
        return annoyingLevel;
    }

    public void setAnnoyingLevel(int annoyingLevel) {
        if (annoyingLevel < 1 || annoyingLevel > 10) {
            throw new IllegalArgumentException("annoying level can be only in scale 1-10");
        }
        this.annoyingLevel = annoyingLevel;
    }

    @Override
    public String toString() {
        return getSpecies() + " " + getName() + " annoying lv: " + annoyingLevel;
    }
}
