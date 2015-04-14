package com.company;

/**
 * Created by Nicholas on 11/16/2014.
 */
public class radixSort {
    public static void sort(int[] list){
        int m = list[0];
        int exp = 1;
        int n = list.length;
        int[] b = new int[10];
        for (int i = 1; i < n; i++){
            if (list[i] > m)
                m = list[i];
        }
        while (m / exp > 0){
            int[] bucket = new int[10];
            for (int i = 0; i < n; i++)
                bucket[(list[i]/exp)%10]++;
            for (int i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (int i = n - 1; i >= 0; i--)
                b[--bucket[(list[i]/exp)%10]] = list[i];
            for (int i = 0; i <n; i++)
                list[i] = b[i];
            exp *= 10;
        }
    }
}
