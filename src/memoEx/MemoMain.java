package memoEx;

import java.util.Scanner;

public class MemoMain {
    public void run(){
        while (true){
            Scanner scanner = new Scanner(System.in);

            System.out.println("안녕하세요 아래의 메뉴중 한가지를 선택해주세요");
            System.out.println("1. 게시글리스트 2. 게시글 보기 3. 게시글 쓰기 4. 게시글 수정 5. 게시글 삭제 6. 종료");

            int selectedMenu = scanner.nextInt();

            if( 1 == selectedMenu){
                
            } else if ( 2 == selectedMenu) {
                
            } else if ( 3 == selectedMenu ) {
                
            } else if( 4 == selectedMenu ) {

            } else if ( 5 == selectedMenu ) {

            } else if ( 6 == selectedMenu ) {
                break;
            }else {
                System.out.println("선택할 수 없습니다. 다시 선택해주세요");
            }

        }
    }
}
