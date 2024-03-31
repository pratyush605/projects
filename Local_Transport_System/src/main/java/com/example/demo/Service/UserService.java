package com.example.demo.Service;

import com.example.demo.Graph.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepo;

import java.util.*;

import static com.example.demo.Graph.Dijkstra.dijkstra;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public User saveDetails(User user) {
		return userRepo.save(user);
	}

	public List<User> getUsers(){
		return userRepo.findAll();
	}

	public boolean login(User user){
		List<User> list = getUsers();
		for(int i=0;i< list.size()-1;i++)
			if (Objects.equals(user.getUserName(), list.get(i).getUserName()) && Objects.equals(user.getPassword(), list.get(i).getPassword()))
				return true;
		return false;
	}
	public ArrayList<String> shortestPathBetween(Graph g, Vertex startingVertex, Vertex targetVertex){
		Dictionary[] dictionaries = dijkstra(g,startingVertex);
		Dictionary distances = dictionaries[0];
		Dictionary prevoius = dictionaries[1];

//		Integer distance = (Integer) distances.get(targetVertex.getData());
//		System.out.println("Shortest Distance Between "+ startingVertex.getData()+" and "+targetVertex.getData());
//		System.out.println(distance);

		ArrayList<Vertex> path = new ArrayList<>();
		ArrayList<String> pathName = new ArrayList<>();
		Vertex v = targetVertex;
		while (!v.getData().equals("null")){
			path.add(v);
			v=(Vertex) prevoius.get(v.getData());
		}
		for(Vertex n: path){
			pathName.add(n.getData());
		}
		return pathName;
	}
}
