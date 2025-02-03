package util;

import java.util.Scanner;

public class InputScanner {
    private static final Scanner scanner = new Scanner(System.in);
    private InputScanner() {}

    public static Scanner getScanner() {
        return scanner;
    }
}
