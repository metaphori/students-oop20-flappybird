package model.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class LeaderboardManagerImpl implements LeaderboardManager{

    public Leaderboard leaderboard;
    private Gson gson;
    final String SEP = File.separator ;
    final String FILE_NAME = System.getProperty("user.home") + 
            SEP + "game.json";
    
    public LeaderboardManagerImpl() {
        leaderboard = new Leaderboard();
        gson = new GsonBuilder().setPrettyPrinting().create();
    }
    
    @Override
    public void read() {
        // TODO Auto-generated method stub
        try (Reader reader = new FileReader(FILE_NAME)) {

            // Convert JSON File to Java Object
            leaderboard = gson.fromJson(reader, Leaderboard.class);
                        
                        // print staff 
           // System.out.println(leaderboard);

        } catch (IOException e) {
            e.printStackTrace();
        }
     
    }

    @Override
    public void write() {
        // TODO Auto-generated method stub
        try (final FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(leaderboard, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewGamer(String name, String score) {
        // TODO Auto-generated method stub
        Gamer gamer = new Gamer(name);
        gamer.setScore(score);
        leaderboard.addGamer(gamer);
        
    }
    
    public List<Gamer> getLeaderboard() {
        return this.leaderboard.getLeadbord();
    }

}
