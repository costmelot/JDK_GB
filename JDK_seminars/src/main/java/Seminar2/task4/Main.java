package Seminar2.task4;

public class Main {
    public static void main(String[] args) {
       Developer dev = new FronEndDeveloper();
       Developer dev1 = new FullStackProgrammer();

        if (dev instanceof FronEndDeveloper) {
            ((FronEndDeveloper)dev).developGUI();
        }
        if (dev1 instanceof FronEndDeveloper) {
            ((FronEndDeveloper)dev1).developGUI();
        }
    }
}
