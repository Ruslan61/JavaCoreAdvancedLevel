package lesson5;

import java.util.Arrays;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }

    public static void firstMethod() {
        System.out.println("Первый метод запущен");

        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);

        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Время работы первого метода " + (System.currentTimeMillis() - a));
    }

    public static void secondMethod() {
        System.out.println("Второй метод запущен");

        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        float[] arrHalfOne = new float[h];
        float[] arrHalfTwo = new float[h];
        long b = System.currentTimeMillis();
        System.arraycopy(arr, 0, arrHalfOne, 0, h);
        System.arraycopy(arr, h, arrHalfTwo, 0, h);

        Thread calcOne = new Thread(() -> {
            for (int i = 0; i < arrHalfOne.length; i++) {
                arrHalfOne[i] = (float)(arrHalfOne[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        calcOne.start();

        Thread calcTwo = new Thread(() -> {
            for (int i = 0; i < arrHalfTwo.length; i++) {
                arrHalfTwo[i] = (float) (arrHalfTwo[i] * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f + (i + h) / 5) * Math.cos(0.4f + (i + h) / 2));
            }
        });
        calcTwo.start();

        try {
            calcOne.join();
            calcTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arrHalfOne, 0, arr, 0, h);
        System.arraycopy(arrHalfTwo, 0, arr, h, h);
        System.out.println("Время работы второго метода " + (System.currentTimeMillis() - b));
    }
}
