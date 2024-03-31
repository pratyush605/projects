package com.example.demo.Graph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Input {
    private String source;
    private String destination;

    public ArrayList<Vertex> station=new ArrayList<>();
    public Graph autoNetwork = new Graph(true, false);

    // Creating stations
    public Vertex rambagh = autoNetwork.addVertex("Rambagh");
    public Vertex bhagwanTalkies = autoNetwork.addVertex("Bhagwan Talkies");
    public Vertex bijliGhar = autoNetwork.addVertex("Bijli Ghar");
    public Vertex rajaMandi = autoNetwork.addVertex("Raja Mandi");
    public Vertex khandari = autoNetwork.addVertex("Khandari");
    public Vertex khandauli = autoNetwork.addVertex("Khandauli");
    public Vertex waterWorks = autoNetwork.addVertex("Water Works");
    public Vertex kamlaNagar = autoNetwork.addVertex("Kamla Nagar");

    public Graph getCity() {
        // Creating edges
        autoNetwork.addEdge(rambagh, waterWorks, 10);
        autoNetwork.addEdge(rambagh, bijliGhar, 15);
        autoNetwork.addEdge(rambagh, khandauli, 10);
        autoNetwork.addEdge(waterWorks, bhagwanTalkies, 20);
        autoNetwork.addEdge(waterWorks, kamlaNagar, 10);
        autoNetwork.addEdge(waterWorks, bijliGhar, 10);
        autoNetwork.addEdge(bhagwanTalkies, khandari, 10);
        autoNetwork.addEdge(bhagwanTalkies, rajaMandi, 10);

        return autoNetwork;
    }

    public ArrayList<Vertex> stations(){
        station.add(rambagh);
        station.add(bhagwanTalkies);
        station.add(bijliGhar);
        station.add(rajaMandi);
        station.add(khandari);
        station.add(khandauli);
        station.add(waterWorks);
        station.add(kamlaNagar);
        return station;
    }
    public Vertex getSourceVertex(String station){
        for(Vertex s: stations()){
            if(Objects.equals(s.getData(), station)){
                return s;
            }
        }
        return null;
    }

    public Vertex getDestinationVertex(String station){
        for(Vertex s: stations()){
            if(Objects.equals(s.getData(), station)){
                return s;
            }
        }
        return null;
    }
}
