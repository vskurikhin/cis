package su.svn.algo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Reverse
{
    AtomicInteger count = new AtomicInteger(0);

    private int a[];

    private int[] read(InputStream is)
    {
        List<Integer> list = new ArrayList<>();

        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            list.add(s.nextInt());
        }

        a = new int[list.size()];
        list.stream().parallel().forEach(e -> a[count.incrementAndGet()] = e);

        return a;
    }

    public Reverse(InputStream is)
    {
        a = reverce(read(is));
    }

    public Reverse(int a[])
    {
        a = reverce(a);
    }

    int[] reverce(int[] a)
    {
        for (int i = 0; i < a.length / 2; i++) {
            int b = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = b;
        }

        return a;
    }

    public int[] get()
    {
        return a;
    }

    public static void main(String[] args) throws IOException
    {
        System.out.println(Arrays.toString(
            new Reverse(System.in).get()
        ));
    }
}
