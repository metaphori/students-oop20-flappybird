package model.file;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Rapresent the leaderboard of the scores
 */
public class Leaderboard {
    
    private List<Gamer> list;
    
    /**
     * Create a new list which rappresent the leaderboard
     */
    public Leaderboard() {
        this.list = new ArrayList<>();
    }
    
    /**
     * Add a new game to the list
     * 
     * @param gamer
     *              the gamer to add
     */
    void addGamer(Gamer gamer) {
        this.list.add(gamer);
        this.list =List.copyOf(list.stream()
                .sorted( (o1,o2)-> Integer.compare( Integer.parseInt(o1.getScore()), Integer.parseInt(o1.getScore())))
                .collect(Collectors.toList()));
    }
    
    /**
     * Get the 
     * 
     * @param gamer
     *              the gamer to add
     *              
     */
    List<Gamer> getLeaderBoard(){
        return Collections.unmodifiableList(list);
    }
}
