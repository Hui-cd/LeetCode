package Kmeans;

import java.util.HashMap;

public class Test {
//    public HashMap<HashMap<String, String>,Double> clusters;
    public static void main(String[] args) {
        HashMap<String,Double> clusters = new HashMap<>();
        clusters.put("a",3.0);
        clusters.put("a",1.0);
        clusters.put("c",2.0);
//        clusters.compute(clusters.entrySet().stream().min(Comparator.comparingDouble(Map.Entry::getValue)).get().getKey(),(k, v)->v);
        System.out.println(clusters);
    }
}
