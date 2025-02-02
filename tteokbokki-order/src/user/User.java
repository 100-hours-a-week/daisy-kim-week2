package user;

import java.util.Scanner;

public class User {
    private final String name;
    private final String phoneNumber;
    private String address;
    private int cardBalance;

    private static User user;
    //user 생성자
    private User(String name, String phoneNumber, int cardBalance) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.cardBalance = cardBalance;
    }

    //user 객체 반환 함수
    public static User getInstance(String name, String phoneNumber, int cardBalance) {
        if (user == null) {
            user = new User(name, phoneNumber, cardBalance);
        }
        return user;
    }

    //잔액 반환 함수
    public int getCardBalance() {
        return cardBalance;
    }

    //결제 시 잔액 차감 함수 -> 아마 pay 클래스로 가야할지도?
    public void updateCardBalance(int cardBalance) {
        this.cardBalance = cardBalance;
    }

    //주소 설정 함수
    public void setAddress() {
        Scanner sc = new Scanner(System.in);

        System.out.println("음식을 배달시킬 주소를 알려주세요. : ");
        this.address = sc.nextLine();
    }

    //메인 함수로 옮길 수도?
    public static User setUserInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("사용자의 이름을 입력하세요.: ");
        String userName = sc.nextLine();

        System.out.println("사용자의 전화번호를 입력하세요.(ex.010-0000-0000) : ");
        String phoneNumber = sc.nextLine();

        System.out.println("카드에 남아있는 잔액을 알려주세요. : ");
        int cardBalance = sc.nextInt();

        User user = User.getInstance(userName, phoneNumber, cardBalance);
        user.setAddress();

        return user;
    }
}
