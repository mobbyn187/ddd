package course.java.pl.oop.trainer.animal;

public class Equipment {
    private String name;
    // wearLevel ma zamknięty zestaw wartości (new, used, terrible)
    // Może warto użyć enum zamiast String, żeby nie można było utworzyć sprzętu
    // z dowolną/niepoprawną wartością?
    private String wearLevel;
    private int repairCount;

    public Equipment(String name, String wearLevel) {
        this.name = name;
        this.wearLevel = wearLevel;
    }
    public void repair() {
        repairCount++;
    }

    public int getRepairCount() {
        return repairCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWearLevel() {
        return wearLevel;
    }

    public void setWearLevel(String wearLevel) {
        this.wearLevel = wearLevel;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "name='" + name + '\'' +
                ", wearLevel='" + wearLevel + '\'' +
                '}';
    }
}
