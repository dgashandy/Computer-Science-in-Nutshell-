package Sort;

import java.util.Random;

public class Sorting {

    public static int N = 20;
    public static int[] sequence = new int[N];
    private static final int MAX_RANGE = 100000;

    public static void sort(int[] arr)
    {
        int N = arr.length;
        if (N == 0)
            return;
        int max = arr[0], min = arr[0];
        for (int i = 1; i < N; i++)
        {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        int range = max - min + 1;

        if (range > MAX_RANGE)
        {
            System.out.println("\nError : Range terlalu besar");
            return;
        }

        int[] count = new int[range];
        for (int i = 0; i < N; i++)
            count[arr[i] - min]++;
        for (int i = 1; i < range; i++)
            count[i] += count[i - 1];
        int j = 0;
        for (int i = 0; i < range; i++)
            while (j < count[i])
                arr[j++] = i + min;
    }

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < N; i++)
            sequence[i] = Math.abs(random.nextInt(10));

        for (int i = 0; i < N; i++)
            System.out.print(sequence[i] + " ");
        System.out.println();

        sort(sequence);
        System.out.println("-------------------------------");

        for (int i = 0; i < N; i++)
            System.out.print(sequence[i] + " ");
        System.out.println();
    }
}
