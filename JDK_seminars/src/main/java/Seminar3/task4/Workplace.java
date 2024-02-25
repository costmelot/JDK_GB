package Seminar3.task4;

public class Workplace <T extends Person> {
    Person[] persons;

    Workplace(Person[] persons) {
        for (Person person : persons) {
            person.doWork();
        }
    }
}
