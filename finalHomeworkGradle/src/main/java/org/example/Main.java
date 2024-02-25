package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int totalSteps = 1000;
        int positiveResults = 0;
        int negativeResults = 0;

        Map<Integer, String> results = new HashMap<>();

        Random random = new Random();

        for (int i = 0; i < totalSteps; i++) {
            int chosenDoor = random.nextInt(3) + 1;
            int winingDoor = random.nextInt(3) + 1;

            if (chosenDoor == winingDoor) {
                positiveResults++;
                results.put(i,"Позитивный");
            } else {
                negativeResults++;
                results.put(i, "Негативный");
            }
        }

        double positivePercentage = (double) positiveResults / totalSteps * 100;
        System.out.println("Позитивные результаты: " + positiveResults);
        System.out.println("Негативные результаты: " + negativeResults);
        System.out.println("Процент позитывных " + positivePercentage + "%");

        System.out.println("Результаты по шагам:");
        for (Map.Entry<Integer, String> entry: results.entrySet()) {
            System.out.println("Шаг " + entry.getKey() + ": " + entry.getValue());
        }

    }
}