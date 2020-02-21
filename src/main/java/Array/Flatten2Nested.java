package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Kevin
 * @createDate: 2020/2/18
 * @version: 1.0
 */
public class Flatten2Nested {

    public static void main(String[] args) {
        Map<String,Integer> map1 = new HashMap<>();
        map1.put("A",1);
        Map<String,Integer> map2 = new HashMap<>();
        map2.put("B.A",2);
        Map<String,Integer> map3 = new HashMap<>();
        map3.put("B.B",3);
        Map<String,Integer> map4 = new HashMap<>();
        map4.put("CC.D.E",4);
        Map<String,Integer> map5 = new HashMap<>();
        map5.put("CC.D.F",5);
        ArrayList<Map<String,Integer>> fallten = new ArrayList<>();
        fallten.add(map1);
        fallten.add(map2);
        fallten.add(map3);
        fallten.add(map4);
        fallten.add(map5);
        Flatten2Nested solution = new Flatten2Nested();
        String res = solution.Flatten2Nested(fallten);
        System.out.println("Nested res:"+res); // Nested res:{CC={D={E=4, F=5}}, A=1, B={A=2, B=3}}
    }

    public String Flatten2Nested(ArrayList<Map<String,Integer>> fallten){
        ArrayList<Map<String, Object>> nested = new ArrayList<>();
        Map<String, Object> newMap = new HashMap<>();
        for (Map<String, Integer> item : fallten) {
            for (String key : item.keySet()) {
                if (!key.contains(".")){
                    newMap.put(key, item.get(key));
                }else{
                    String[] list = key.split("\\.");
                    int length = list.length;
                    Map<String, Object> nowMap = newMap;
                    for (int i = 0; i < length-1; i++) {
                        if (nowMap.containsKey(list[i])){
                            nowMap = (Map<String, Object>)nowMap.get(list[i]);
                        }else{
                            Map<String, Object> empty = new HashMap<>();
                            nowMap.put(list[i], empty);
                            nowMap = (Map<String, Object>)nowMap.get(list[i]);
                        }
                    }
                    nowMap.put(list[length-1], item.get(key));
                }
            }
        }

        return newMap.toString();
    }
}
