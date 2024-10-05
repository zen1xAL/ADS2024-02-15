package by.it.group351002.vlasovets.lesson06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Задача на программирование: наибольшая возрастающая подпоследовательность
см.     https://ru.wikipedia.org/wiki/Задача_поиска_наибольшей_увеличивающейся_подпоследовательности
        https://en.wikipedia.org/wiki/Longest_increasing_subsequence

Дано:
    целое число 1≤n≤1000
    массив A[1…n] натуральных чисел, не превосходящих 2E9.

Необходимо:
    Выведите максимальное 1<=k<=n, для которого гарантированно найдётся
    подпоследовательность индексов i[1]<i[2]<…<i[k] <= длины k,
    для которой каждый элемент A[i[k]]больше любого предыдущего
    т.е. для всех 1<=j<k, A[i[j]]<A[i[j+1]].

Решить задачу МЕТОДАМИ ДИНАМИЧЕСКОГО ПРОГРАММИРОВАНИЯ

    Sample Input:
    5
    1 3 3 2 6

    Sample Output:
    3
*/

public class A_LIS {


    int getSeqSize(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //общая длина последовательности
        int n = scanner.nextInt();
        int[] m = new int[n];
        //читаем всю последовательность
        for (int i = 0; i < n; i++) {
            m[i] = scanner.nextInt();
        }
        int result = 0;
        int[] seq = new int[n];
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!

        // Инициализируем массив seq, в котором будем хранить длины возрастающих подпоследовательностей.
        // Каждая подпоследовательность, заканчивающаяся на i-м элементе массива m, будет иметь длину,
        // не меньше 1 ( сам i-й элемент - это подпоследовательность).
        for (int i = 0; i < n; i++) {
            seq[i] = 1;
            // Проходим по всем элементам до i-го элемента.
            for (int j = 0; j < i; j++) {
                // Если m[j] меньше m[i] и длина подпоследовательности, заканчивающейся на j-м элементе,
                // плюс 1 больше текущей длины подпоследовательности, заканчивающейся на i-м элементе,
                // то обновляем длину подпоследовательности, заканчивающейся на i-м элементе.
                if (m[j] < m[i] && seq[j] + 1 > seq[i]) {
                    seq[i] = seq[j] + 1;
                }
            }
            // Обновляем максимальную длину возрастающей подпоследовательности.
            result = Math.max(result, seq[i]);
        }

        return result;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson06/dataA.txt");
        A_LIS instance = new A_LIS();
        int result = instance.getSeqSize(stream);
        System.out.print(result);
    }
}