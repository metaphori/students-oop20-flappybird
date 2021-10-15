package model.file;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Leaderboard {
    
    private List<Gamer> list;
    
    public Leaderboard() {
        this.list = new ArrayList<>();
    }
    
    void addGamer(Gamer gamer) {
        this.list.add(gamer);
    }
    
    void removeGamer(Gamer gamer) {
        this.list.remove(gamer);
    }
    
    List<Gamer> getLeadbord(){
        return Collections.unmodifiableList(list);
    }

}
