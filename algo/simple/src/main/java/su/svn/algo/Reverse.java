package su.svn.algo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Reverse
{
    volatile static int i = 0;

    static int[] read(InputStream is)
    {
        List<Integer> list = new ArrayList<>();

        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            list.add(s.nextInt());
        }

        int a[] = new int[list.size()];
        list.forEach(e -> a[i++] = e);

        return a;
    }

    static int[] reverce(int[] a)
    {
        for (int i = 0; i < a.length / 2; i++) {
            int b = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = b;
        }

        return a;
    }


    public static void main(String[] args) throws IOException
    {
        System.out.println(Arrays.toString(
            reverce(read(System.in))
        ));
    }
}
