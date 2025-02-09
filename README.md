<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=cylinder&color=0:be2727,100:502a2a&text=엽기떡볶이&section=header&fontAlignY=48&fontSize=60&height=150&animation=blinking&desc=스레드를%20이용한%20비동기%20프로그램%20만들기&descAlignY=76&fontColor=f7cdcd" />
</p>
<br>

--- 

## 📚 프로젝트 주제
엽기 떡볶이 배달 어플<br>
2주차 과제 레포지토리입니다.

1주차에 구현한 동기 프로그램을 비동기 프로그램으로 만들기<br>
1-1. 간단한 스레드 구현<br>
1-2. 스레드간 상호작용할 수 있는 기능 구현

<br>

## 📜 사용자 메뉴얼
1. 사용자 정보 입력
   - 이름<br>
     ❗️ 예외 상황 : 영어 또는 한글을 제외한 다른 문자일 때 재입력
   
   - 전화번호<br>
     ❗️ 예외 상황 : 숫자, '-'가 아니거나 전화번호가 9자리 미만, 12자리 초과일 시 재입력
   - 카드 잔액<br>
     ❗️ 예외 상황 : 0 미만의 숫자, 숫자가 아닌 문자일 때 재입력
   - 배달 주소<br>
     ❗️ 예외 상황 : 영어, 숫자, 한글을 제외한 다른 문자를 포함할 때 재입력

2. ▶️ ${\color{#ff0000}[추가\ 기능]\ 랜덤\ 쿠폰\ 수령\ 여부\ 질문}$<br>
   쿠폰 목록을 먼저 보여주며 사용자에게 랜덤 쿠폰을 뽑을지 질문함
   1. [1: 예]를 선택하면 자동으로 즉시 쿠폰 부여하며 3번에서 [1 : 예]를 선택한 이후부터 쿠폰 타이머의 시간이 흘러감
   2. [2: 아니오]를 선택하면 쿠폰 제공 없이 3번으로 넘어감
   
3. 주문 동의 받기<br>
   1. [1: 예]를 선택하면 다음 4번으로 넘어감
   2. [2: 아니오]를 선택하면 어플을 종료한다는 문구와 함께 프로세스가 종료됨

4. 메뉴 선택
   1. 떡볶이를 선택하였을 경우 추가 선택 진행
      - 매운맛 정도
      - 토핑 선택 최대 3회<br><br>
   2. 사이드를 선택하였을 경우 추가 선택 없음<br>

5. 장바구니 담을지에 대한 여부 선택<br>
   1. [2: 메뉴 다시 담기]를 선택하면 3번 과정으로 돌아감

6. 추가 주문 여부 선택<br>
   1. [1: 예]를 선택하면 4번 과정으로 돌아감
   2. [2: 아니오]를 선택하면 장바구니 목록 출력
  
7. 결제 여부 선택<br>
   1. [1: 예]를 선택하면 결제가 완료되었다는 문구 출력 후 3번으로 돌아감
      - ▶️ ${\color{#ff0000}쿠폰을\ 받았을\ 경우\ 결제\ 즉시\ 쿠폰\ 사용과\ 함께\ 쿠폰은\ 소멸됨}$
      - ▶️ ${\color{#ff0000}결제\ 여부를\ 선택하는\ 시간동안\ 쿠폰\ 타이머는\ 흘러가지\ 않음}$
   2. [2: 아니오]를 선택하면 별도의 문구 출력 없이 3번으로 돌아감
      - ▶️ ${\color{#ff0000}프로그램을\ 종료하지\ 않았으며\ 결제는\ 한\ 적이\ 없기\ 때문에\ 쿠폰은\ 아직\ 소멸되지\ 않음}$
   
❗️ 2번 이후의 공통 예외 상황 : 선택해야 하는 범위의 숫자를 넘어선 숫자나 문자를 입력할 때 재입력 요청

<br>

--- 

<br>

## 👀 실행 결과
![Image](https://github.com/user-attachments/assets/30c25423-e865-4111-a22f-d516fbc8681b)

<br><br>

## 🤔 설계 및 구현 과정
### 1. CLI 비동기 프로그램 구현 예시 찾아보기<br>
   비동기라는 단어를 들었을 때 감이 오지 않았다.
   
   최소 2명의 사용자가 있어야 결과를 보여줄 수 있는 거 아닌가?<br>
   한 프로그램에 대해 여러 프롬프트를 동시에 켤 수 있어야 되는 거 아닌가?<br>
   하는 의문이 들었다.
   
   우선 주제를 정하기 위해 인터넷에 "CLI 비동기 프로그램", "스레드 자바 비동기 CLI 프로그램" 등 키워드 섞어가면서 계속 검색했다.<br>
   하지만 2주차 과제와 유사하거나 참고할 만한 자료를 쉽게 찾을 수 없었다.<br>
   때문에 다른 사람과의 상호작용을 이용하지 않는 선에서 주제를 생각해야 했다. 그러다 보니 생각나는 거라고는 단순 시간 출력 밖에 없었다.<br>
   하지만 기존 1주차와 연결 지으려니 설계도 안 되고 아무리 과제라 해도 서비스라고 생각하고 맥락은 있어야 하니까 적어가면서 진행했다.<br>
   
   결론적으로 Temu 어플이 생각났다. <br>
   앱에 들어갈 때마다, 또는 알람으로 룰렛을 돌려서 26만 원 이상 구매할 경우 13만 원어치 쿠폰이나 3만 원 이상 구매할 경우 2개의 무료 상품을 주는 쿠폰에 시간제한을 걸어 제공하는 방식이다.

   프로그램을 실행시킬 때마다 "시간 제한 할인 쿠폰"을 제공하는 엽기 떡볶이 주문 서비스로 주제를 확정 지었다.
   
   
### 2. 설계 및 구현

### 구성

- Coupon 클래스
  - 1Dollar : 60초 내 결제하면 1천 원 할인
  - 3Dollar : 30초 내 결제하면 3천 원 할인
  - 5Dollar : 20초 내 결제하면 5천 원 할인
  - 10Dollar : 10초 내 결제하면 1만 원 할인<br>
  클래스명이 숫자로 시작해도 되는지 모르곘지만 쿠폰 이름을 가격으로 구분 짓는 것이 가독성이 좋을 것이라 판단했다.<br>
  Coupon 클래스에는 하위 클래스에는 없는 isSold 속성이 있다. → 이건 구현하면서 추가함

- CouponFactory 클래스
  쿠폰 클래스에 속성이 하나가 아니어서 enum으로 종류를 리스트업할 수 없다고 생각하여 Map 사용
  
- CouponManagement 클래스
  처음에는 쿠폰 클래스에 전부 합칠까? 생각했지만 쿠폰 종류 자체의 클래스와 쿠폰과 관련된 행위가 있는 클래스를 구분하는 것이 더 깔끔하다고 생각했다.<br>
  어차피 메소드가 행위고 속성이 종류면 하나로 해도 되지 않나? 싶었지만 메뉴 클래스와 Order 클래스를 분리했던 것처럼 이도 분리하는 것이 SRP 원칙에 더 맞다고 판단하였다.
  
- Timer 클래스
  스레드를 상속 받는 클래스이다.<br>
  사실 여기부터는 설계에 안 들어가고 구현하면서 생각해냈다.<br>
  쿠폰 부분은 1주차 덕인지 쉽게 설계도 되고 구현도 됐는데 여기는 도무지 감이 안 왔기 때문이다.<br>
  타이머를 주제로 하고 인터넷에 스레드 타이머를 검색하니 참고 자료를 많이 볼 수 있었다.<br>

### 구현
쿠폰 클래스의 설계가 쉽게 됐듯이 구현도 쉽게 됐다.<br>
정말 1주차 덕을 많이 본 기분이다.<br>

Timer 클래스를 어느 정도 구현하고 실행을 반복하다 보니 할인 쿠폰을 적용하려면 결제 부분을 건드려야 한다는 사실이 보였다.<br>
결제 부분을 어느 정도 건드리고 다시 Timer, 스레드 부분으로 돌아왔다.<br>
Timer 클래스만 작성했다보니 다른 클래스와의 상호작용을 어떻게 구현해야 할지 생각나지 않았다.

그러다가 얼추 다 구현했다 싶었는데 테스트에 테스트에 테스트를 하다보니 되던 게 안 되고 안 되던 게 왜 되는지 모르겠는데 되고 암튼 난리였다.

1차 시도 - 처음에는 사용자에게 입력 받는 Scanner 역할의 스레드 받는 상속 클래스를 하나 더 만들었다가 아무리 해도 예외 처리가 안 되길래 포기했다. 사실 무슨 소리인지도 못 알아들은 듯하다.<br>
2차 시도 - 스레드를 중단하는 스레드를 만들었다. 근데 이것도 예외처리 실패<br>
중간중간 다른 예외도 보이긴 했는데 이래저래 어떻게 해결할지 한 단계 한 단계씩 해결책이 보이는 부분들은 해결해 나갔다.<br>
그리고 어떻게 해결할지 모르겠는 오류가 있었는데 몇 번씩 현재 스레드가 주인이 아니라는 오류가 났는데 나중에 Thread-main이라는 부분을 보게 되었다.
<img width="858" alt="스크린샷 2025-02-10 오전 2 19 09" src="https://github.com/user-attachments/assets/828a024d-bd3e-4eeb-8dbd-3304629adb29" /><br>

owner 저게 제어권을 말하나? 싶은 생각에 갑자기
<br>'아 어차피 Timer 스레드와 main 스레드만 있어도 어차피 두 스레드의 상호작용이구나!'
<br>하고 싹 지우고 다시 24시간 전으로 돌아갔다.<br>
조금 허무했는데 예전에 전부 지우는 다른 때보다 Thread-main를 봐서 그런지 유레카 같아서 훨씬 덜 허무했다.<br>
암튼 다시 돌아가서 어차피 순차적인 스레드보다 서로 중단도 해 보고 다시 재개도 하게 하는 스레드의 상호작용이 이번 과제의 핵심인 것 같으니 잘됐다 싶었다.<br>

그렇게 "결제하시겠습니까?" 질문 나올 때 타이머 스레드 중단하는 것부터 구현하였다.<br>
이후 "새 주문을 시작합니다. 동의하시겠습니까?" 질문에 또 타이머 스레드 중단하는 것을 구현하였다.<br>
사실 결제하시겠습니까?만 구현했다가 새 주문 어쩌구도 구현하다 보니 스레드 중단을 잘못 시키고 있는 부분이 보이기도 했고<br>
단순 결제 시점에 처리하면 이게 중단을 하는 건지 스레드를 꺼버리는 건지 알 수가 없는데 새 주문 어쩌구에도 적용하였더니<br>
'아 진짜 중단이 맞네' 하고 구현을 끝낼 수 있었다.


### 3. 확장성/기대효과
   소비자가 특정 쿠폰을 노리거나 1분 단위로 프로그램을 실행했다가 껐다가 하는 경우 회사에 불이익을 줄 수 있다.<br>
   때문에 CLI 프로그램 특성 상 프로그램 종료 이후 시간을 계산할 수 없지만 실제 서비스를 구현한다고 가정했을 때 소비자의 악용을 막기 위한 방안이 필요해 보인다.<br>
   또한, 실제 테무 어플처럼 사용자에게 점심, 저녁, 또는 야식 시간에 알림을 보내 소비를 촉진시킬 수 있는 시스템을 구축하는 방향으로도 확장할 수 있을 것이다.

   반면, 할인 받아 떡볶이를 구매할 경우 결국 돈을 사용하는 것임에도 불구하고 할인을 받는다고 생각해 이득을 본다는 심리가 작용한다고 한다.<br>
   이처럼 할인에 대한 경제 심리를 이용하여 쿠폰 타이머를 적용한다면 더 많은 판매량을 기대할 수 있을 것이다.
   


<br>

---
  
<br>

## 💡 회고

밤 새면서 하면 좋은 점이 진짜 집중이 잘된다는 건데 단점이 다음날 뭘 구현하고 어떻게 구현했는지 하나도 기억이 나지 않는다는 것이다.<br>
왜 그런지는 모르겠다. 모든 업무가 끝나지 않으면 잠을 못 자겠는 이유이기도...~~
밤에 구현 시작하면 8시간이고 그냥 엉덩이 붙이는 게 어떻게 가능한 건지도 모르겠고 자고 일어나면 기억이 왜 순삭되는 건지 또 알 수가 없다. 훔하<br>
그래서 사실 지금 아무 생각도 안 듦... 허허

그래도 여름에 2달 내내 인턴할 동안 매일 일기 썼던 게 도움이 되는 것 같다. <br>
그때부터 나름 기록의 습관이 조금 생겼는데 글 쓰는 게 어렵다는 생각은 들지 않아 다행이다.

1주차 과제 때는 아무리 실전 구현 경험이 없어도 이론 상 익숙했던 것들이라 감을 금방 찾았었는데 이번에는 진짜 맨땅에 헤딩한 기분이었다.<br>
스레드 예외처리로만 하루 꼴딱 넘어갈 거라고는 생각지도 못했다.<br>
근데 진짜 저 Thread-main이 유레카였다. <br>
한 번 Timer 스레드를 실행시킨 순간 아 Timer 밖에서는 나 아무 스레드 함수도 쓸 수 없구나를 알았기 때문이다.<br>
저거 보고 main과 타이머 스레드 간 상호작용이 이미 있었구나 하는 것도 바로 깨달을 수 있었고 inerrupt() 함수, wait() 함수가 돌아가는 것도 갑자기 확 머리에 들어왔다.<br>
내가 짜놓고 나 왜 이렇게 구현한 거지, 아니 이거 왜 돌아가지, 아니 어디서 안 되는 거지 진짜 복잡함의 연속이었는데 갑자기 해결능력 탑재된 것 마냥 하나씩 보여서 해결했다.

근데 하나 좀 의문인 게 notify()를 사용하고 싶었는데 이 부분이 잘 되지 않아 그냥 interrupt() 처리 했더니 대기 상태의 스레드가 다시 돌아갔다.<br>
인터넷에서는 notify() - wait() 이렇게 반대 관계라고 해서 계속 쓰다가 안 되길래 interrupt() 냅다 넣었더니 스레드가 아예 소멸하는 게 아니라 다시 굴러가는 방향으로 움직여서 이 부분은 아직도 좀 의문이다.<br>

그래도 저번주에는 화요일 되는 새벽에 과제를 끝내서 마음도 급하고 잠도 못자고 월요일 아키텍처 수업 복습도 못했는데 이번주는 가능할 것 같아서 기분이 좋다.<br>
사실 구현 일찍 끝낼 수 있을 줄 알고 아키텍처 공부하고 딥다이브도 정리 더 해보려고 했는데 그건 실패...<br>
아무래도 주말에는 과제를 몰아서 하고 평일에는 수업 복습에 매진해서 밀리는 게 없도록 관리해야 하는 듯하다.<br>
밀림의 연속이긴 하지만 저번주보다는 늦지 않다는 생각에 조금 안심..휴~
