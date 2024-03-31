package com.example.demo.Graph;

import java.util.*;

public class GraphTraverser {
    public static void depthFirstTraversal(Vertex start, ArrayList<Vertex> visitedVertices){
        System.out.println(start.getData());
        for(Edge e: start.getEdges()){
            Vertex neighbor = e.getEnd();
            if(!visitedVertices.contains(neighbor)){
                visitedVertices.add(neighbor);
                GraphTraverser.depthFirstTraversal(neighbor,visitedVertices);
            }
        }
    }

    public static void breathFirstTraversal(Vertex start, ArrayList<Vertex> visitedVertices){
        Queue<Vertex> visitQueue = new LinkedList<>();
        visitQueue.add(start);
        while(!visitQueue.isEmpty()){
            Vertex current = visitQueue.remove();
            System.out.println(current.getData());
            for(Edge e: current.getEdges()){
                Vertex neighbor = e.getEnd();
                if(!visitedVertices.contains(neighbor)){
                    visitedVertices.add(neighbor);
                    visitQueue.add(neighbor);
                }
            }
        }
    }
}