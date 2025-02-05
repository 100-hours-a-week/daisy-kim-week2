package user;

import util.InputScanner;
import validation.InputCheck;

import java.util.Scanner;

public class User {
    private final String name;
    private final String phoneNumber;
    private String address;
    private int cardBalance;

    private static User user;
    private static final Scanner scanner = InputScanner.getScanner();
    private static final InputCheck inputCheck = new InputCheck();

    private User(String name, String phoneNumber, int cardBalance, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.cardBalance = cardBalance;
        this.address = address;
    }

    public static User getInstance(String name, String phoneNumber, int cardBalance, String address) {
        if (user == null) {
            user = new User(name, phoneNumber, cardBalance, address);
        }
        return user;
    }

    public int getCardBalance() {
        return cardBalance;
    }

    public void updateCardBalance(int cardBalance) {
        this.cardBalance = cardBalance;
    }

    public String getName() {
        return name;
    }

    private static String setName() {
        String name = "";
        while(true) {
            System.out.print("사용자의 이름을 입력하세요. : ");
            name = scanner.nextLine();
            boolean result = inputCheck.isValidName(name);
            if (result) {
                break;
            }
            System.out.println("잘못된 입력입니다. 영문 또는 한국어 이름을 입력해 주세요.");
        }
        return name;
    }

    private static String setPhoneNumber() {
        String phoneNumber = "";
        while(true) {
            System.out.print("사용자의 전화번호를 입력하세요.(ex.010-0000-0000) : ");
            phoneNumber = scanner.nextLine();
            boolean result = inputCheck.isValidPhoneNumber(phoneNumber);
            if (result) {
                break;
            }
            System.out.println("잘못된 전화번호 입력입니다. 예시에 맞는 형식으로 입력해 주세요.");
        }
        return phoneNumber;
    }

    private static int setIntContent() {
        int intContent = 0;
        while(true) {
            System.out.print("카드에 남아있는 잔액을 알려주세요. : ");
            intContent = inputCheck.getValidCardBalance();
            if (intContent >= 0) {
                break;
            }
            System.out.println("잔액이 없습니다. 잔액을 채우고 오세요.");
            scanner.nextLine();
        }
        return intContent;
    }

    private static String setAddress() {
        String address = "";
        while(true) {
            System.out.print("음식을 배달시킬 주소를 알려주세요. : ");
            address = scanner.nextLine();
            boolean result = inputCheck.isValidAddress(address);
            if (result) {
                break;
            }
            System.out.println("잘못된 입력입니다. 영문 또는 한국어로 입력해 주세요.");
        }
        return address;
    }

    public static User setUserInfo() {
        String userName = setName();
        String phoneNumber = setPhoneNumber();
        int cardBalance = setIntContent();
        scanner.nextLine();
        String address = setAddress();

        User user = User.getInstance(userName, phoneNumber, cardBalance, address);

        return user;
    }
}
