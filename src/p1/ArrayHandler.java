package p1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayHandler {

    private static int [] arrayToHandle = {0, 1, 9, 34, 0, 5, 0, 1, 6, -9, 12, 65};

    public static void main(String[] args) {

        double average = getAverageArrayValue(arrayToHandle);
        System.out.println("Average value = " + average);
        double average2 = getAverageArrayValue2(arrayToHandle);
        System.out.println("Average value second variant = " + average2);

        int countOfElementsEqualToZero = getCountOfElementsEqualToZero(arrayToHandle);
        System.out.println("Count of elements, which are equal to zero = " +
                countOfElementsEqualToZero);

        int countOfElementsGreaterThanZero = getCountOfElementsGreaterThanZero(arrayToHandle);
        System.out.println("Count of elements, which are greater than zero = " +
                countOfElementsGreaterThanZero);

        int [] multipliedArray = multipleArrayElementsByNumber(arrayToHandle, 2);
        System.out.print("Multiplied array: ");
        showArray(multipliedArray);

        Map<Integer, Integer> minElementAndIndex = findMinElementsIndexAndValue(arrayToHandle);
        System.out.println("Min element and its' index: " + minElementAndIndex);

    }

    private static Map<Integer, Integer> findMinElementsIndexAndValue(int [] arrayToHandle) {
        Map<Integer, Integer> result = new HashMap();
        Arrays.stream(arrayToHandle).filter(element -> {
            return element == Arrays.stream(arrayToHandle).min().getAsInt();
        }).forEach(element -> result.put(element, getIndex(arrayToHandle, element)));

        return result;
    }

    private static int getIndex(int [] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    private static int [] multipleArrayElementsByNumber(int [] arrayToHandle, int multiplier) {
        int [] resultingArray = Arrays.stream(arrayToHandle).map(element -> {
            return element *= multiplier;
        }).toArray();

        return resultingArray;
    }

    private static int getCountOfElementsGreaterThanZero(int [] arrayToHandle) {
        return (int)Arrays.stream(arrayToHandle).filter(element -> element > 0).count();
    }

    private static int getCountOfElementsEqualToZero(int [] arrayToHandle) {
        return (int)Arrays.stream(arrayToHandle).filter(element -> element == 0).count();
    }

    private static double getAverageArrayValue(int [] arrayToHandle) {
        return Arrays.stream(arrayToHandle).average().getAsDouble();
    }

    private static double getAverageArrayValue2(int [] arrayToHandle) {
        return (Arrays.stream(arrayToHandle).asDoubleStream().reduce((accumulator, element) ->
                accumulator + element
        ).getAsDouble() / Arrays.stream(arrayToHandle).count());
    }

    private static void showArray(int [] arrayToHandle) {
        Arrays.stream(arrayToHandle).forEach(element -> System.out.print(element + " "));
        System.out.println();
    }
}
