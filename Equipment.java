package course.java.pl.oop.trainer.animal;

public class Equipment {
    private String name;
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
