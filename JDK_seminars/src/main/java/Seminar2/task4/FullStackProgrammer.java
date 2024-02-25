package Seminar2.task4;

public class FullStackProgrammer extends Developer implements BackEndProgramming, FronEndProgramming {

    @Override
    public void writeBackEndCode() {
        System.out.println("Пишет бэкенд");
    }

    @Override
    public void developGUI() {
        System.out.println("Пишет фронтэнд");
    }

    @Override
    void drinkCoffee() {
        System.out.println("Drinks a lot of coffee");
    }

    @Override
    void smoke() {
        System.out.println("Smokes POD's");
    }
}
