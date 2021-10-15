package model.file;

import java.util.List;

public interface LeaderboardManager {
    
    void addNewGamer(String name, String score);
    
    void read();
    
    void write();

    List<Gamer> getLeaderboard();
}
