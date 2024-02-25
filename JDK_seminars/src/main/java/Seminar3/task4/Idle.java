package Seminar3.task4;

public class Idle implements Person{
    @Override
    public void doWork() {
        System.out.println(this.getClass().getName() + " No!");
    }

    @Override
    public void haveRest() {
        System.out.println(this.getClass().getName() + " Let's fun!!!");
    }
}
