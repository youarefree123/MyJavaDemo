package Generic;

public class Pair<T,U> {
    private T first;
    private U second;

    public Pair(){
        first = null;
        second = null;
    }
    public Pair(T first , U second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(U second) {
        this.second = second;
    }
}
