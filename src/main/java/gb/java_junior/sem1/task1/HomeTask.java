package gb.java_junior.sem1.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeTask {
    /**
     * Напишите программу, которая использует Stream API для обработки списка чисел.
     * Программа должна вывести на экран среднее значение всех четных чисел в списке.
     */
    public static void main(String[] args) {
        List<Integer> listOFIntegers = new ArrayList<>();
        fillUp(listOFIntegers, 6);
        System.out.println("Исходный список: " + listOFIntegers);
        printAverageOfEvenElements(listOFIntegers);
    }
    /**
     * Метод заполняет список значениями от 0 до 100 включительно
     * @param list - список, который нужно заполнить значениями
     * @param size - размер списка
     */
    public static List<Integer> fillUp(List<Integer> list, int size) {
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rnd.nextInt(101));
        }
        return list;
    }
    public static void printAverageOfEvenElements(List<Integer> list) {
        System.out.println("Среднее арифметическое чётных элементов равно: ");
        int sumOfOddElements = list.stream()
                .filter(element -> element % 2 == 0)
                .reduce((element, sum) -> sum += element)
                .get();
        int count = (int) list.stream()
                .filter(element -> element % 2 == 0)
                .count();
        System.out.println(sumOfOddElements * 1.0 / count);
    }
}