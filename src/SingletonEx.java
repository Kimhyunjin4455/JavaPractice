public class SingletonEx {
    // 인스턴스를 한번 생성하고 여러 메서드에서 공유하며 사용
    private static SingletonEx singletonEx;

    private String myName = "현진";
    private String myHome = "화목";

    private SingletonEx(){
    }

    public static SingletonEx getInstance(){
        // 인스턴스를 생성할 수 있는 특정 메서드 생성
        if(singletonEx == null){
            singletonEx = new SingletonEx();
        }
        return singletonEx;
    }

    public String getMyName(){
        return myName;
    }
    public String getMyHome(){
        return myHome;
    }

    public void free(){
        singletonEx = null;
    }
}
