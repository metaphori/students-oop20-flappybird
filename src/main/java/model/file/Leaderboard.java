package model.file;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;



public class Leaderboard {
    
    private List<Gamer> list;
    
    public Leaderboard() {
        this.list = new ArrayList<>();
    }
    
    void addGamer(Gamer gamer) {
        this.list.add(gamer);
        this.list =List.copyOf(list.stream()
                .sorted( (o1,o2)-> Integer.compare( Integer.parseInt(o1.getScore()), Integer.parseInt(o1.getScore())))
                .collect(Collectors.toList()));
    }
    
    void removeGamer(Gamer gamer) {
        this.list.remove(gamer);
    }
    
    List<Gamer> getLeadbord(){
        return Collections.unmodifiableList(list);
    }

}
