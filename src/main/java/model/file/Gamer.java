package model.file;

public class Gamer {
    
    private String name;
    private String score;
    
    public Gamer(String name) {
        this.name = name;
        
    }
    
    public void setScore(String score) {
        this.score = score;
    }
    
    public String getName() {
        return this.name;
    }

    public String getScore() {
        return this.score;
    }
}
