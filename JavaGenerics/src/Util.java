
public class Util {
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
               p1.getValue().equals(p2.getValue());
    }
    public  static void main(String[] args){
    	Pair<String, String> p1 = new Pair<String, String>("k1", "v1");
    	Pair<String, String> p2 = new Pair<String, String>("k1", "v1");
  
    	boolean b = Util.<String, String>compare(p1, p2);
    	System.out.println(b);
    }
}