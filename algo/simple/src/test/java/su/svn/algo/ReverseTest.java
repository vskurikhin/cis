package su.svn.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReverseTest
{
    int test00[] = new int[]{};
    int expected00[] = new int[]{};
    @Test
    void testCase00()
    {
        new Reverse(test00);
        assertArrayEquals(expected00, test00);
    }

    int test01[] = new int[]{0};
    int expected01[] = new int[]{0};
    @Test
    void testCase01()
    {
        new Reverse(test01);
        assertArrayEquals(expected01, test01);
    }

    int test02[] = new int[]{0, 1};
    int expected02[] = new int[]{1, 0};
    @Test
    void testCase02()
    {
        new Reverse(test02);
        assertArrayEquals(expected02, test02);
    }

    int test03[] = new int[]{0, 1, 2};
    int expected03[] = new int[]{2, 1, 0};
    @Test
    void testCase03()
    {
        new Reverse(test03);
        assertArrayEquals(expected03, test03);
    }
}