package lesson5.homework;

import java.util.Arrays;

public class HomeWork {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {4, 5};
        System.out.println(
                Arrays.toString(concat(a, b)) // [1, 2, 3, 4, 5]
        );

        int[][] d = {
                {1, 2, 3},
                {4}
        };
        System.out.println(
                Arrays.toString(flatten(d)) // [1, 2, 3, 4]
        );

        int[] e = {2, 3, 1};
        int[] f = {4, 5, 3, 2};

        System.out.print(
                Arrays.toString(findDuplicates(e, f))
        );

        System.out.println(
                Arrays.toString(findUnique(e,f))
        );


    } // окончание main


    // Напишите функцию, которая найдет в двух массивах уникальные элементы и
    // вернет их в виде массива (порядок не важен)
    public static int[] findUnique(int[] a, int[] b) {
        int[] c = concat(a, b);
        int[] d = new int[c.length];
        Arrays.sort(c);
        // {1,2,2,3,3,4,5}
        int numberOfUnique = 0; // количество найденных уникальных элементов
        System.out.println(Arrays.toString(c)); // debug
        for (int i = 0; i < c.length; i++) {
            if (
                    ((i > 0 && c[i] != c[i - 1]) || i == 0) &&
                            ((i < c.length - 1) && c[i] != c[i + 1] || i == c.length - 1)

            ) {
                d[numberOfUnique++] = c[i];
            }
        }
        System.out.println(Arrays.toString(d)); // debug
        System.out.println("numberOfUnique: " + numberOfUnique);
        // результат
        int[] r = new int[numberOfUnique];
        for (int i = 0; i < numberOfUnique; i++) {
            r[i] = d[i];
        }
        return r;
    }


    // Напишите функцию, которая найдет в двух массивах одинаковые элементы и
    // вернет их в виде массива (порядок не важен)
    public static int[] findDuplicates(int[] a, int[] b) {
        int[] c = concat(a, b);
        int[] d = new int[c.length]; // хранилище дубликатов
        Arrays.sort(c);
        // System.out.println(Arrays.toString(c)); // debug
        int numberOfDuplicates = 0; // количество найденных дубликатов
        for (int i = 1; i < c.length; i++) {
            // [1,2,2,3,4]
            if (c[i] == c[i - 1] && (numberOfDuplicates == 0 || c[i] != d[numberOfDuplicates - 1])) {
                d[numberOfDuplicates++] = c[i];
            }
        }
        // System.out.println(Arrays.toString(d)); // debug
        // System.out.println("number of duplicates: " + numberOfDuplicates); // debug

        // результат
        int[] r = new int[numberOfDuplicates];
        for (int i = 0; i < numberOfDuplicates; i++) {
            r[i] = d[i];
        }

        return r;

    }


    // Напишите функцию для "уплощения" передаваемого в нее двухмерного массива.
    public static int[] flatten(int[][] a) {
        int size = 0; // количество элементов в двухмерном массиве
        for (int i = 0; i < a.length; i++) {
            size += a[i].length;
        }
        int[] c = new int[size];
        int currentIndex = 0; // текущая позиция для записи в массив "с"
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                c[currentIndex++] = a[i][j];
            }
        }
        return c;
    }

    // Напишите функцию, принимающую на вход два массива целых
    // и возвращающую один массив, содержащий все их элементы
    public static int[] concat(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            c[i + a.length] = b[i];
        }
        return c;
    }
}
