package Seminar2.task4;

public class FronEndDeveloper extends Developer implements FronEndProgramming {
    @Override
    void drinkCoffee() {
        System.out.println("Drink coffee");
    }

    @Override
    void smoke() {
        System.out.println("Smoke the cigars");
    }

    public void developGUI() {
        System.out.println("create GUI");
    }
}
