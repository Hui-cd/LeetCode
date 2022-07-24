package Kmeans;

import java.util.ArrayList;
import java.util.List;

public class Cluster {
    private List<Data> cluster = new ArrayList<>();
    public Cluster(List<Data> cluster){
        this.cluster = cluster;
    }
    public List<Data> getCluster(){
        return cluster;
    }
    public void setCluster(List<Data> cluster){
        this.cluster = cluster;
    }
    public void addCluster(Data data){
        this.cluster.add(data);
    }
    public void removeCluster(Data data){
        this.cluster.remove(data);
    }

    /**
     * 计算聚类中心
     */
//    public void calculateCenter(){
//        int size = cluster.size();
//        int latitudeSize = cluster.get(0).getLatitude().size();
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < latitudeSize; j++) {
//                float sum = 0;
//                for (int k = 0; k < size; k++) {
//                    sum = (float) cluster.get(k).getLatitude().get(j);
//                }
//                float average = sum/size;
//                cluster.get(i).getLatitude().set(j, average);
//            }
//        }
//    }


    public void clearCluster(){
        this.cluster.clear();
        this.cluster = new ArrayList<>();
    }


}
