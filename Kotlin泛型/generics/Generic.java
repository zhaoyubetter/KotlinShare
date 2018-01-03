package generics;

public class Generic<T> {
    private T key;

    public Generic(T key) {
        this.key = key;
        if(key instanceof String){
            System.out.println("Generic -> " + key);
        }
    }

    public T getKey() {
        return key;
    }
}
