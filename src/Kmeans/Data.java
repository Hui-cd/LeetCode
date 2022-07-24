package Kmeans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Data {


    ArrayList<ArrayList<String>> columns = new ArrayList<ArrayList<String>>();
    BufferedReader reader = null;
    String currentLine;
    Map<String,String> keyParam = new HashMap<>();


    public Data(){
    }


    public Map<String, String> ingest(String pathname) throws IOException {
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
        }
        input.close();
        return keyParam;

    }

    public static void main(String[] args) throws IOException {
        Data data = new Data();
        data.ingest("/Users/hui/IdeaProjects/LeetCode/src/Kmeans/housing.csv");
    }
}
