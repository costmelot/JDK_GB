package Seminar3.task4;

public class Club <T extends Person>{
    Person[] persons;

    Club(Person[] persons) {
        for (Person person : persons) {
            person.haveRest();
        }
    }
}
