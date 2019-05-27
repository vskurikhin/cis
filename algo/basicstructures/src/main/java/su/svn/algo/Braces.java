package su.svn.algo;

import java.io.*;
import java.util.Stack;

/**
 * Скобки в коде
 * Проверить, правильно ли  расставлены  скобки  в  данном  коде.   Вход.
 * Исходный код  программы.   Выход.   Проверить,  верно  ли  расставлены
 * скобки. Если нет, выдать индекс первой ошибки.
 *
 * Вы  разрабатываете  текстовый  редактор  для  программистов  и  хотите
 * реализовать проверку корректности расстановки скобок.   В  коде  могут
 * встречаться   скобки   []{}().    Из  них  скобки  [,{ и (   считаются
 * открывающими, а соответству- ющими им закрывающими  скобками  являются
 * ],} и ).
 *
 * В случае, если скобки расставлены неправильно, редактор  должен  также
 * сообщить пользователю первое место, где обнаружена ошибка.   В  первую
 * очередь необходимо найти закрывающую  скобку,  для  которой  либо  нет
 * соответствующей открывающей (например, скобка ] в строке “]()”),  либо
 * же она закрывает не соответствующую ей откры- вающую  скобку  (пример:
 * “()[}”).  Если таких ошибок нет, необходи- мо найти первую открывающую
 * скобку, для которой нет соответству- ющей закрывающей (пример:  скобка
 * ( в строке “{}([]”).
 *
 * Помимо скобок,  исходный  код  может  содержать  символы  латин  ского
 * алфавита, цифры и знаки препинания.
 *
 * Формат входа.
 * Строка   s[1 ... n],   состоящая    из  заглавных  и  прописных   букв
 * латинского алфавита, цифр, знаков препинания  и  скобок  из  множества
 * []{}().
 *
 * Формат выхода.
 * Если скобки в s расставлены правильно, выведите строку  “Success".   В
 * противном случае выведите  индекс  (используя  индексацию  с  единицы)
 * первой   закрывающей   скобки,   для   которой   нет   соответствующей
 * открывающей.  Если  такой  нет,  выведите  индекс  первой  открывающей
 * скобки, для которой нет соответствующей закрывающей.
 *
 */

class MyReader extends BufferedReader
{
    MyReader(InputStream is)
    {
        super(new InputStreamReader(is));
    }

    MyReader()
    {
        this(System.in);
    }
}

class Brace
{
    static boolean isLeft(char c)
    {
        return '(' == c || '{' == c || '[' == c;
    }

    static boolean isRight(char c)
    {
        return ')' == c || '}' == c || ']' == c;
    }

    static boolean isntPair(char open, char closed)
    {
        return (   ('(' == open && ')' != closed)
                || ('{' == open && '}' != closed)
                || ('[' == open && ']' != closed)
        );
    }

    static boolean isBraces(char c)
    {
        return isLeft(c) || isRight(c);
    }
}

class BalanceChecker
{
    private int position;

    private final boolean result;

    private class CharPosition
    {
        CharPosition(char c, int p)
        {
            this.c = c;
            this.p = p;
        }
        char c;
        int p;
    }

    private boolean isBalanced(String s)
    {
        position = 0;
        Stack<CharPosition> stack = new Stack<CharPosition>();

        for (char c : s.toCharArray()) {
            position++;
            if ( ! Brace.isBraces(c))
                continue;
            if (Brace.isLeft(c)) {
                stack.push(new CharPosition(c, position));
            } else {
                if (stack.empty()) {
                    return false;
                }
                CharPosition top = stack.pop();
                if (Brace.isntPair(top.c, c)) {
                    return false;
                }
            }
        }

        if ( ! stack.empty()) {
            position = stack.peek().p;
            return false;
        }

        return true;
    }

    BalanceChecker(String line)
    {
        result = isBalanced(line);
    }

    boolean check()
    {
        return result;
    }

    int getPosition()
    {
        return position;
    }
}

public class Braces
{
    public static void main(String[] args) throws IOException
    {
        String line = new MyReader().readLine();
        BalanceChecker balance;
        boolean result = (balance = new BalanceChecker(line)).check();
        System.out.println(result ? "Success" : balance.getPosition());
    }
}
