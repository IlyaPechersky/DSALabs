package lab03;

public class Main3 {

    public final static int N = 5;

    public static void main(String[] args) {


        ILinkedHashMap<String, String> map = new LinkedHashMap<>(N);

        System.out.println("added");
        map.put("John Smith", "5211234");
        System.out.println(map);

        System.out.println("added");
        map.put("Lisa Smith", "5218976");
        System.out.println(map);

        System.out.println("added");
        map.put("Ted Baker", "4184165");
        System.out.println(map);

        System.out.println("added");
        map.put("Sam Doe", "5215030");

        System.out.println("added");
        map.put("Sandra Dee", "5219655");
        System.out.println(map);

        System.out.println("added null key with null value");
        map.put(null, null);
        System.out.println(map);

        System.out.println("update entry of null key");
        map.put(null, "Hello");
        System.out.println(map);

        System.out.println("removed null");
        map.remove(null);
        System.out.println(map);

        System.out.println("getting value of key 'John Smith'");
        System.out.println(map.get("John Smith"));
        System.out.println(map);

        System.out.println("removed 'John Smith'");
        map.remove("John Smith");
        System.out.println(map);

    }
}
