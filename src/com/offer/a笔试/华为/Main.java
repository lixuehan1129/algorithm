package com.offer.a笔试.华为;


import java.util.*;

public class Main {
    static List<String> res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        List<String> listO = new ArrayList<>();
        int flag = 0;
        while (sc.hasNext()){
            String s = sc.next();
            if(s.equals("eof")) break;
            if(s.equals("performance")) continue;
            if(s.equals("organization")){
                flag = 1;
                continue;
            }
            if (flag == 0){
                String[] strings = s.split(",");
                map.put(strings[0], Integer.parseInt(strings[1]));
            }
            else listO.add(s);
        }

        res = new ArrayList<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        for(String s : listO){
            String[] strs = s.split(",");
            for (String str : strs){
                if(!priorityQueue.contains(s)) {
                    priorityQueue.offer(str);
                }
            }
        }
        Map<String, Integer> mapNum = new HashMap<>();
        List<String> listNum = new ArrayList<>();
        int count = 0;

        while (!priorityQueue.isEmpty()){

            String s = priorityQueue.poll();

            if(!mapNum.containsKey(s)) {
                mapNum.put(s, count++);
                listNum.add(s);
            }
        }



        TireNode root = new TireNode(count);
        for (String s : listO) {
            String[] strs = s.split(",");
            TireNode node = root;
            int index = 0;
            for (String str : strs) {
                index = mapNum.get(str);
                if(node.Node[index] == null){
                    node.Node[index] = new TireNode(count);
                }

                node = node.Node[index];
                node.weight = map.getOrDefault(str, 0);
            }

        }
        dfs(root, listNum, 0);

        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.print(res.get(i) + "\n");
        }
    }

    public static int dfs(TireNode node, List<String> list, int k){
        if(node == null) return 0;
        int weight = 0;
        for(int i = 0; i < node.Node.length; i++){
            if(node.Node[i] == null) continue;
            if(k == 2){
                res.add("--" + list.get(i) + "<" + node.Node[i].weight + ">");
                weight += node.Node[i].weight;
            }else if(k == 1){
                int w = dfs(node.Node[i], list, k + 1);
                res.add( "-" + list.get(i) + "<" + w + ">");
                weight += w;
            }else{
                weight += dfs(node.Node[i], list, k + 1);
                res.add(list.get(i) + "<" + weight + ">");
            }
        }
        return weight;

    }
}

class TireNode{
    int weight;
    TireNode[] Node;
    public TireNode(int capacity){
        Node = new TireNode[capacity];
        weight = 0;
    }
}
