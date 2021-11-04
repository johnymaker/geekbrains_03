package com.company;
import java.util.Scanner;

public class JavaApp {

    public static void main(String[] args) {

        guessTheNumber();
        guessTheWord();

    }

    public static void guessTheWord() {

        String[] words = new String[] {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String word = getRandomWord(words);

        String userWord = readWord();

        while (!word.equals(userWord)) {
            String partOfWord = compareWords(word, userWord);
            printWord(partOfWord);
            userWord = readWord();
        }

        System.out.println("Поздравляем! Вы угадали слово: " + userWord);
    }

    public static String getRandomWord(String[] arr) {
        int i = (int)(Math.random() * arr.length);
        System.out.println(arr[i]);
        return arr[i];
    }

    public static String readWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово: ");
        String str = scanner.nextLine();
        return str;
    }

    public static String compareWords(String w1, String w2) {

        String str = new String();
        int minLength = w1.length() < w2.length() ? w1.length() : w2.length();
        int i = 0;

        while (i < minLength && w2.charAt(i) == w1.charAt(i)) {
            str += w2.charAt(i);
            i++;
        }
        return str;
    }

    public static void printWord(String str) {
        System.out.print(str);
        for (int i = str.length(); i < 15; i++) {
            System.out.print("#");
        }
        System.out.println();
    }

    public static void guessTheNumber() {

        int num = getRandomNumber(0, 9);
        int userNum = readFromConsoleIn();

        while (num != userNum) {
            if (num < userNum) {
                System.out.println("x < " + userNum);
                userNum = readFromConsoleIn();
            } else if (num > userNum) {
                System.out.println("x > " + userNum);
                userNum = readFromConsoleIn();
            }
        }
        System.out.println("Поздравляем! Вы угадали число: " + num);
    }

    public static int getRandomNumber(float min, float max) {
        int x = (int)(Math.random() * (max - min + 1) + min);
        System.out.println(x);
        return x;
    }

    public static int readFromConsoleIn() {
        Scanner console = new Scanner(System.in);
        System.out.print("Введите число 0 - 9: ");
        int x = console.nextInt();
        return x;
    }
}
