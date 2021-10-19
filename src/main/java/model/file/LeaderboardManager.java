package model.file;

import java.util.List;

public interface LeaderboardManager {
    
    void addNewGamer(Gamer gamer);
    
    void read();
    
    void write();

    List<Gamer> getLeaderboard();
}
