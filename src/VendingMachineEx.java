import java.util.Scanner;

public class VendingMachineEx {
    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        final String[] beverageNames = {"스프라이트", "환타", "코카콜라제로"};
        final int[] beverageCost = {1100, 1300, 1500};
        final int[] beverageStock = {5,3,8};
        int index = 0;
        int money = 0;
        int selectedBeverage = -1;  // 선택되지 않았다는 뜻
        int isExit = 0;


        do{
            for(int i=0; i<beverageNames.length; i++){
                System.out.println(String.format("%d. %s 가격: %d원", i+1, beverageNames[i], beverageCost[i]));
            }


            do{
                Scanner scanner = new Scanner(System.in);
                System.out.println(" 돈을 투입해 주세요.");
                money += scanner.nextInt();

                do{
                    System.out.println(" 음료를 선택해주세요");
                    selectedBeverage = scanner.nextInt();

                    if(selectedBeverage <= 0){
                        System.out.println(String.format(" %s 음료의 재고가 없습니다. 다른 음식을 선택해주세요", beverageNames[selectedBeverage]));
                    }
                }while (beverageStock[selectedBeverage] <= 0);

                if(money < beverageCost[selectedBeverage]){
                    System.out.println("금액이 부족합니다.");
                }
            }while(beverageCost[selectedBeverage] > money);

            money -= beverageCost[selectedBeverage];
            beverageStock[selectedBeverage] -= 1;


            System.out.println(String.format("%s 를 구매했습니다.", beverageNames[selectedBeverage]));
            System.out.println(String.format("남은 금액은 %d 원입니다.", money));
            System.out.println("거스름돈을 반환받겠습니까?(맞으면 1 누르기, 아니면 0)");
            Scanner scanner = new Scanner(System.in);
            isExit = scanner.nextInt();

            if(isExit == 1){
                System.out.println("이용해주셔서 감사합니다.");
            }

        }while (isExit == 0);




    }
}
