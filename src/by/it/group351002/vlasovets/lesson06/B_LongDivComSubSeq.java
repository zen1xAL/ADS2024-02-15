package by.it.group351002.vlasovets.lesson06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Задача на программирование: наибольшая кратная подпоследовательность

Дано:
    целое число 1≤n≤1000
    массив A[1…n] натуральных чисел, не превосходящих 2E9.

Необходимо:
    Выведите максимальное 1<=k<=n, для которого гарантированно найдётся
    подпоследовательность индексов i[1]<i[2]<…<i[k] <= длины k,
    для которой каждый элемент A[i[k]] делится на предыдущий
    т.е. для всех 1<=j<k, A[i[j+1]] делится на A[i[j]].

Решить задачу МЕТОДАМИ ДИНАМИЧЕСКОГО ПРОГРАММИРОВАНИЯ

    Sample Input:
    4
    3 6 7 12

    Sample Output:
    3
*/

public class B_LongDivComSubSeq {


    int getDivSeqSize(InputStream stream) throws FileNotFoundException {
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
        //тут реализуйте логику задачи методами динамического программирования (!!!)
        int result = 0;
        // Создаем массив для хранения длин наибольших кратных подпоследовательностей.
        int[] seq = new int[n];

        // Проходим по всем элементам массива m.
        for (int i = 0; i < n; i++) {
            // Инициализируем длину подпоследовательности, заканчивающейся на i-м элементе, как 1.
            seq[i] = 1;
            // Проходим по всем элементам до i-го элемента.
            for (int j = 0; j < i; j++) {
                // Если m[i] делится на m[j] и длина подпоследовательности, заканчивающейся на j-м элементе,
                // плюс 1 больше текущей длины подпоследовательности, заканчивающейся на i-м элементе,
                // то обновляем длину подпоследовательности, заканчивающейся на i-м элементе.
                if (m[i] % m[j] == 0 && seq[j] + 1 > seq[i]) {
                    seq[i] = seq[j] + 1;
                }
            }
            // Обновляем максимальную длину кратной подпоследовательности.
            result = Math.max(result, seq[i]);
        }

        return result;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson06/dataB.txt");
        B_LongDivComSubSeq instance = new B_LongDivComSubSeq();
        int result = instance.getDivSeqSize(stream);
        System.out.print(result);
    }

}