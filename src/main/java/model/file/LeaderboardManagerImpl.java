package model.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.time.chrono.MinguoChronology;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Rappresent the manager class of the LeaderBoard
 */
public class LeaderboardManagerImpl implements LeaderBoardManager{

    private LeaderBoard leaderBoard;
    private Gson gson;
    final String SEP = File.separator ;
    final String FILE_NAME = System.getProperty("user.home") + 
            SEP + "game.json";
    
    /**
     * Create a new LeaderBoard Manager
     */
    public LeaderboardManagerImpl() {
        leaderBoard = new LeaderBoard();
        
        gson = new GsonBuilder().setPrettyPrinting().create();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void read() {
        // TODO Auto-generated method stub
        File f = new File(FILE_NAME);
        if (f.exists()) {
            try (Reader reader = new FileReader(FILE_NAME)) {

                // Convert JSON File to Java Object
                leaderBoard = gson.fromJson(reader, LeaderBoard.class);
                            
           

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
     
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write() {
      
      
        try (final FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(leaderBoard, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addNewGamer(Gamer gamer) {
        // TODO Auto-generated method stub
        
        if (checkTop10(gamer.getScore())) {
            
            leaderBoard.addGamer(gamer);
           
        }
        
       
     
    }
    
  
    private boolean checkTop10(String score) {
        // TODO Auto-generated method stub
        if (leaderBoard.getLeaderBoard().size()<10) {
            return true;
        }
        
        return Integer.parseInt(score) > leaderBoard.getLeaderBoard().stream()
                .map(i->Integer.parseInt(i.getScore()))
                .sorted().collect(Collectors.toList()).get(0);
        
      
        
       
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Gamer> getLeaderboard() {
        System.out.println(leaderBoard.getLeaderBoard().stream()
                .map(i->Integer.parseInt(i.getScore()))
                .sorted().collect(Collectors.toList()));
        return this.leaderBoard.getLeaderBoard();
    }

}
