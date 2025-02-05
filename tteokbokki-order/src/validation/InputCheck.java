package validation;

import util.InputScanner;

import java.util.Scanner;

public class InputCheck{
    private static final Scanner scanner = InputScanner.getScanner();

    public boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
    public boolean isValidPhoneNumber(String number) {
        if (number == null || number.trim().isEmpty() ||
                number.replaceAll("[- ]", "").length() > 12
                || number.replaceAll("[- ]", "").length() < 9) {
            return false;
        }
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c) && c != '-') {
                return false;
            }
        }
        return true;
    }

    public boolean isValidAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            return false;
        }
        for (char c : address.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ' && !Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public int getValidChoiceInRange(int rangeMax, int rangeMin) {
        int choice = 0;
        while (true) {
            try{
                choice = scanner.nextInt();
                if(choice > rangeMax || choice < rangeMin) {
                    System.out.println("잘못된 입력입니다. 선택지에 있는 번호를 입력해 주세요.");
                    scanner.nextLine();
                    continue;
                }
                break;
            } catch (Exception e){
                System.out.println("잘못된 입력입니다. 숫자를 입력해 주세요.");
                scanner.nextLine();
            }
        }
        return choice;
    }

    public int getValidCardBalance() {
        int balance = 0;
        while (true) {
            try{
                balance = scanner.nextInt();
                break;
            } catch (Exception e){
                System.out.println("잘못된 입력입니다. 숫자를 입력해 주세요.");
                scanner.nextLine();
            }
        }
        return balance;
    }
}
