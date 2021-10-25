package model.file;

/**
 * Rapresent a Gamer
 */
public class Gamer {
    
    private final String name;
    private String score;
    
    /**
     * Create a new Gamer
     * 
     * @param name
     *            the gamer name
     */
    public Gamer(String name) {
        this.name = name;
        
    }
    
    /**
     *Set the score of the gamer
     * 
     * @param score
     *            the score of the gamer
     */
    public void setScore(String score) {
        this.score = score;
    }
    
    /**
     * @return the name of the gamer
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the score of the gamer
     */
    public String getScore() {
        return this.score;
    }
}
