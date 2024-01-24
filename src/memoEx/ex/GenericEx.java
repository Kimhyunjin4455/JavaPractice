package memoEx.ex;

public class GenericEx<T> {
    Object[] genericEx = new Object[10];

    private int cursor = 0;
    public void putData(T data){
        genericEx[cursor++] = data;
    }
    @SuppressWarnings("unchecked")
    public T getData(){
        T data = (T)genericEx[cursor-1]; // 마지막 data의 인덱스는 커서값보다 1작다.
        genericEx[cursor-1] = null;
        cursor--;
        return data;
    }
}
