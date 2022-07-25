package Kmeans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Data {

    Map<String,String> keyParam = new HashMap<>();
    ArrayList<HashMap<String, String>> allData = new ArrayList<>();

    /**
     * 读取数据文件 并将数据存储到allData中 并将数据的key和value存储到keyParam中
     * @param pathname 数据文件路径
     * @return 数据文件中的数据
     * @throws IOException
     */
    public ArrayList<HashMap<String, String>> ingest(String pathname) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(pathname));
        String key = input.readLine();
        List<String> keys = Arrays.stream(key.split(",")).collect(Collectors.toList());
        String s;
        int line =1;
        while ((s = input.readLine())!=null){
            List<String> values = Arrays.stream(s.split(",")).collect(Collectors.toList());
            line++;
            if(keys.size()!=values.size()){
                System.out.println("Error: line "+line+" has different number of columns");
                continue;
            }
             keyParam = IntStream.range(0,values.size()).collect(HashMap::new,(m,i)->m.put(keys.get(i),values.get(i)),HashMap::putAll);
            allData.add((HashMap<String, String>) keyParam);
        }
        input.close();
        return allData;

    }

    /**
     * 获取数据之间的距离 并返回最小的距离
     * @param x
     * @param y
     * @return
     */
    public double getDistance(HashMap<String, String>x, HashMap<String, String>y){
        double distance = 0;
        for(String key:x.keySet()){
            if(x.get(key)!=null&&y.get(key)!=null){
                distance += Math.pow(Double.parseDouble(x.get(key))-Double.parseDouble(y.get(key)),2);
            }
        }
       return Math.sqrt(distance);
    }

    public static void main(String[] args) throws IOException {
        Data data = new Data();
        data.ingest("/Users/hui/IdeaProjects/LeetCode/src/Kmeans/housing.csv");
    }
}
