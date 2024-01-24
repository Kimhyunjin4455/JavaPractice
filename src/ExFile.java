import javax.xml.stream.FactoryConfigurationError;

public class ExFile {
    private String name; // 다른 클래스에서 생성자 통해 인스턴스 생성 후 name 값도 초기화 시킴, 인스턴스 마다 값이 다를 수 있기에 private 처리
    ExFile(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }
    public String toString(){
        return "File명: "+name;
    }

    // equals 는 원래 인스턴스 메모리의 주소를 비교하지만, 아래와 같이 변수끼리 비교하는 식으로 직접 변경 가능
    public boolean equals(Object obj){
        if (obj instanceof ExFile){
            ExFile tempExFile = (ExFile)obj;
            return name.equals(tempExFile.name);
        }
        return false;
    }
    // hashCode 메서드 재정의, equals 재정의 시 같이 재정의하는 것을 스펙상 권장함
    public int hashCode() {
        int salt = 7;
        return 31 * salt * name.hashCode();
    }





}
