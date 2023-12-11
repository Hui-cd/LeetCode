package Kmeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Kmeans cluster 聚类算法
 */
public class Kmeans {
    public Data data;
    public int k;
    public String pathname;
    public ArrayList<HashMap<String, String>> points;
    public ArrayList<HashMap<String, String>> centroids;
    public ArrayList<HashMap<HashMap<String, String>,Double>> pointMinDistance;
    public HashMap<HashMap<String, String>,Double> minDistanceMap;
    public ArrayList<HashMap<HashMap<String, String>,HashMap<String, String>>>clusters;
    public HashMap<HashMap<String, String>,HashMap<String, String>> clustersMap;

    public void centreCalculation() {
        try {
        HashMap<String, String> current = new HashMap<>();
        //计算每个点到质心的距离
        for (HashMap<String, String> point : points) {
            double minDistance = Double.MAX_VALUE;
            for (int i = 0; i <= k; i++) {
                double distance = data.getDistance(point, centroids.get(i));
                minDistance = distance;
                if (distance <= minDistance) {
                    current = centroids.get(i);
                    continue;
                }
            }
            minDistanceMap.put(point, minDistance);
            pointMinDistance.add(minDistanceMap);
            clustersMap.put(current, point);
            clusters.add(clustersMap);
            System.out.println(clusters);

        }}catch (Exception e){
            e.printStackTrace();
        }
    }
    public Kmeans(String pathname,int k) {
        data = new Data();
        this.pathname = pathname;
        this.k = k;
        centroids = new ArrayList<>();
        pointMinDistance = new ArrayList<>();
        clusters = new ArrayList<>();
        clustersMap = new HashMap<>();
        minDistanceMap = new HashMap<>();
        try {
            points = data.ingest(pathname);
            for (int i = 0; i < k; i++) {
                centroids.add(points.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Kmeans kmeans = new Kmeans("/Users/hui/IdeaProjects/LeetCode/src/Kmeans/housing.csv",3);
        kmeans.centreCalculation();
    }
}
