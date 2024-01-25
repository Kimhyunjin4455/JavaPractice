public class DaemonEx implements Runnable{
    public String name;
    public DaemonEx(String name){
        this.name = name;
    }

    public void run(){
        int sum = 0;
        for(int i=0; i<5; i++){
            sum+=i;
        }
        System.out.println(name+" : "+sum);
    }


}
