package course.java.pl.oop.trainer.animal;

import java.time.LocalDate;

public class EquipmentUsage {
    private Trainer trainer;
    private Equipment equipment;
    private LocalDate date;

    public EquipmentUsage(Trainer trainer, Equipment equipment, LocalDate date) {
        this.trainer = trainer;
        this.equipment = equipment;
        this.date = date;
    }

    public boolean wasUsed(Trainer trainer, Equipment equipment) {
        return this.trainer == trainer && this.equipment == equipment;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "EquipmentUsage{" +
                "trainer=" + trainer +
                ", equipment=" + equipment +
                ", date=" + date +
                '}';
    }
}
