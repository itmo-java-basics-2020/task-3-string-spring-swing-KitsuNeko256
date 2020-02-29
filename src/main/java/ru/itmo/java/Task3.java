package ru.itmo.java;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new int[0];
        }
        int x = inputArray[inputArray.length - 1];
        for (int i = inputArray.length - 1; i > 0; --i) {
            inputArray[i] = inputArray[i - 1];
        }
        inputArray[0] = x;
        return inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     * <p>
     * Если входной массив пуст или равен null - вернуть 0
     * <p>
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return 0;
        }
        if (inputArray.length == 1) {
            return inputArray[0];
        }
        int min1 = Integer.MAX_VALUE, min2 = min1;
        int max1 = Integer.MIN_VALUE, max2 = max1;
        for (int value : inputArray) {
            if (value > max1) {
                max2 = max1;
                max1 = value;
            } else if (value > max2) {
                max2 = value;
            }
            if (value < min1) {
                min2 = min1;
                min1 = value;
            } else if (value < min2) {
                min2 = value;
            }
        }
        return Math.max(min1 * min2, max1 * max2);
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     * <p>
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int counter = 0;
        for (char i : input.toCharArray()) {
            if (i == 'a' || i == 'b' || i == 'A' || i == 'B') {
                ++counter;
            }
        }
        return 100 * counter / input.length();
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        if (input.length() == 0) {
            return true;
        }
        for (int i = 0; i < input.length() / 2; ++i) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        int counter = 1;
        char prev = input.charAt(0);
        for (int i = 1; i < input.length(); ++i) {
            if (input.charAt(i) == prev) {
                counter++;
            } else {
                ans.append(prev);
                ans.append(counter);
                counter = 1;
                prev = input.charAt(i);
            }
        }
        ans.append(prev);
        ans.append(counter);
        return ans.toString();
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || one.length() == 0 || two == null || two.length() == 0 || one.length() != two.length()) {
            return false;
        }
        int[] count = new int[65536];
        for (int i = 0; i < one.length(); ++i) {
            ++count[one.charAt(i)];
            --count[two.charAt(i)];
        }
        for (int i = 0; i < 65536; ++i) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean[] count = new boolean[65536];
        for (int i = 0; i < s.length(); ++i) {
            if (!count[s.charAt(i)]) {
                count[s.charAt(i)] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     * <p>
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return new int[2][0];
        }
        for (int i = 0; i < m.length - 1; ++i) {
            for (int j = i + 1; j < m.length; ++j) {
                int x = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = x;
            }
        }
        return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     * <p>
     * Запрещается пользоваться функций join
     * <p>
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null || inputStrings.length == 0) {
            return "";
        }
        if (separator == null) {
            separator = ' ';
        }
        StringBuilder ans = new StringBuilder();
        ans.append(inputStrings[0]);
        for (int i = 1; i < inputStrings.length; ++i) {
            ans.append(separator);
            ans.append(inputStrings[i]);
        }
        return ans.toString();
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null) {
            return 0;
        }
        int ans = 0;
        for (String str : inputStrings) {
            if (str.startsWith(prefix)) {
                ++ans;
            }
        }
        return ans;
    }
}
