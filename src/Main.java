import memoEx.ex.GenericEx;
import memoEx.MemoMain;
import memoEx.ex.StringEX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        //
        MemoMain main = new MemoMain();
        main.run();


        // 6번 입력시 아래 내용 실행됨
        ExFile exFile = new ExFile("Img");
        System.out.println(exFile);

        // 커스텀 예외 테스트
//        ExFile exFile1 = new ExFile("Html");
//        if (exFile1.getName() == "Html"){
//            throw new CustomException();
//        }
//        System.out.println(exFile1);

//        System.out.println(exFile.equals(exFile1));

        SingletonEx singletonEx = SingletonEx.getInstance();
        System.out.println(singletonEx.getMyName());
        System.out.println(singletonEx.getMyHome());
        singletonEx.free(); // 싱글톤 인스턴스 해제

        GenericEx<StringEX> genericEx = new GenericEx<>();
        genericEx.putData(new StringEX());
        System.out.println(genericEx.getData());

        ArrayList<String> text = new ArrayList<>();
        text.add("김");
        text.add("현");
        text.add("진");

        text.set(1,"이");
        System.out.println(text);
        System.out.println(text.get(2));
        //text.remove(2);//text.remove("진");
        // ArrayList는 배열 기반이므로 value보다 index로 찾아 제거하는 것이 속도면에서 효율적

        // ArrayList의 논리적 공간 늘리기
        for (int i = 0; i < 20; i++) {
            // null 값으로 채운다
            text.add(null);
        }

        int size = text.size();
        System.out.println(size);


        // LinkedList는 노드끼리의 참조값을 가지고 있는 이중 연결 리스트
        // 데이터 삽입/삭제가 빠르지만, 특정 데이터 찾기엔 비효율적(접근보다 삽입/삭제 많을 경우에 유용)
        // 특정 데이터 찾을 땐 최초 생성 노드부터 차례대로 검색하기 때문.
        // 당연하지만 데이터가 많을수록 삭제는 시간이 더 소요됨

        LinkedList<String> texts = new LinkedList<>();

        texts.add("딸기");
        texts.add("포도");
        texts.add("사과");
        // 딸기 -> 포도 -> 사과

        // 첫 번째 Node의 앞에 삽입
        texts.addFirst("시작");
        // 시작 -> 딸기 -> 포도 -> 사과

        // 마지막 Node의 뒤에 삽입
        texts.addLast("마지막");
        // 시작 -> 딸기 -> 포도 -> 사과 -> 마지막

        texts.add(1, "중간!");
        // 딸기 -> 중간! -> 포도 -> 사과

        String text2 = texts.get(1);
        // 포도

        // 인덱스를 이용한 값 삭제
        texts.remove(1);

        // 값을 검색하여 값 삭제
        texts.remove("중간!");

        // 맨 앞의 값을 삭제
        texts.removeFirst();

        // 맨 뒤의 값을 삭제
        texts.removeLast();




        Thread thread2 = new Thread(new DaemonEx("데몬스레드2"));
        thread2.start();

        System.out.println("메인 스레드 종료");

//        try {
//            thread2.sleep(7000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }



    }

    public void threadTest(){
        Thread thread1 = new Thread(new DaemonEx("데몬스레드1"));
        thread1.setDaemon(true);

        thread1.start();
    } // 메인스레드가 아닌 데몬스레드이기에 메인스레드 종료와 함께 종료됨
}