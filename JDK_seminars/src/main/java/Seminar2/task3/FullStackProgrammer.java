package Seminar2.task3;

public class FullStackProgrammer implements BackEndProgramming, FronEndProgramming{

    @Override
    public void writeBackEndCode() {
        System.out.println("Пишет бэкенд");
    }

    @Override
    public void writeFrontEndCode() {
        System.out.println("Пишет фронтэнд");
    }
}
