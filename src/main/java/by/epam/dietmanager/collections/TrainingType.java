package by.epam.dietmanager.collections;

public enum TrainingType {
    POWER("Силовая"),
    CARDIO("Кардио"),
    OTHER("Другое");

    public final String rus;

    public String rus(){
        return rus;
    }

    TrainingType(String rus) {
        this.rus = rus;
    }

}
