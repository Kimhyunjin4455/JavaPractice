import memoEx.ex.GenericEx;
import memoEx.MemoMain;
import memoEx.ex.StringEX;

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


    }
}