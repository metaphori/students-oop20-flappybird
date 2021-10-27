package model.file;

import java.util.List;

/**
 *Rappresent the manager interface of the LeaderBoard
 */
public interface LeaderboardManager {
    
    /**
     *Add new gamer to the top10
     *
     *@param gamer
     *            the gamer to add
     */
    void addNewGamer(Gamer gamer);
    
    /**
     *Read from the file system the leaderBoard
     */
    void read();
    
    /**
     *Write on the file system the leaderBoard
     */
    void write();

    /**
     *@return the leaderBoard
     */
    List<Gamer> getLeaderboard();
}
