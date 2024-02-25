package Seminar3.task4;

public class Worker implements Person{
    @Override
    public void doWork() {
        System.out.println(this.getClass().getName() + " I work hard");
    }

    @Override
    public void haveRest() {
        System.out.println(this.getClass().getName() + " I have no time for rest, I need to work");
    }
}
