import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Box<T> {

    private T t;          

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <U extends Number> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }
    public static void process(List<? extends Number> list) {
        for (Number elem : list) {
            System.out.println(elem.toString());
        }
    }
    public  static <U extends Number> void process1(List<U> list) {
        for (Number elem : list) {
            System.out.println(elem.toString());
        }
    }
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.set(new Integer(10));
        integerBox.<Integer>inspect(0); // error: this is still String!
        List<String> listOne = Collections.<String>emptyList();
        List<Float> iList = Arrays.asList(3f, 4f);
        //iList.add(1.1f);
       // iList.add(2.2f);
        process1(iList);
    }
}