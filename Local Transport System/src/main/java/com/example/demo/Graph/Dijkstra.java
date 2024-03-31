package com.example.demo.Graph;

import java.util.*;

public class Dijkstra {
    public static Dictionary[] dijkstra(Graph g, Vertex startingVertex){
        Dictionary<String,Integer> distances = new Hashtable<>();
        Dictionary<String,Vertex> previous = new Hashtable<>();
        PriorityQueue<QueueObject> queue = new PriorityQueue<QueueObject>();

        queue.add(new QueueObject(startingVertex,0));
        for(Vertex v: g.getVertices()){
            if(v!=startingVertex){
                distances.put(v.getData(),Integer.MAX_VALUE);
            }
            previous.put(v.getData(),new Vertex("null"));
        }
        distances.put(startingVertex.getData(),0);
        while(!queue.isEmpty()){
            Vertex current = queue.poll().vertex;
            for(Edge e: current.getEdges()){
                Integer alternative = distances.get(current.getData())+e.getWeight();
                String neighborValue = e.getEnd().getData();
                if(alternative<distances.get(neighborValue)){
                    distances.put(neighborValue,alternative);
                    previous.put(neighborValue,current);
                    queue.add(new QueueObject(e.getEnd(),distances.get(neighborValue)));
                }
            }
        }
        return new Dictionary[]{distances,previous};
    }

    public static void dijkstraResultPrinter(Dictionary[] d){
        System.out.println("Distances:\n");
        for(Enumeration keys = d[0].keys(); keys.hasMoreElements();){
            String nextKey = keys.nextElement().toString();
            System.out.println(nextKey+": "+d[0].get(nextKey));
        }
        System.out.println("\nPrevious:\n");
        for(Enumeration keys = d[1].keys(); keys.hasMoreElements();){
            String nextKey = keys.nextElement().toString();
            Vertex nextVertex = (Vertex)d[1].get(nextKey);
            System.out.println(nextKey+": "+nextVertex.getData());
        }
    }

    public static void shortestPathBetween(Graph g, Vertex startingVertex, Vertex targetVertex){
        Dictionary[] dictionaries = dijkstra(g,startingVertex);
        Dictionary distances = dictionaries[0];
        Dictionary prevoius = dictionaries[1];

        Integer distance = (Integer) distances.get(targetVertex.getData());
        System.out.println("Shortest Distance Between "+ startingVertex.getData()+" and "+targetVertex.getData());
        System.out.println(distance);

        ArrayList<Vertex> path = new ArrayList<>();
        Vertex v = targetVertex;
        while (v.getData()!="null"){
            path.add(0,v);
            v=(Vertex) prevoius.get(v.getData());
        }
        System.out.println("Shortest Distance:");
        for(Vertex pathVertex: path){
            System.out.println(pathVertex.getData());
        }
    }
}
