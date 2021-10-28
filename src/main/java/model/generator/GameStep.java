package model.generator;

/**
 * Step of the difficult of the game
 */
public enum GameStep {
    
    /**
     * level of difficult
     */
    EASY_DOWN(0),
    
    /**
     * level of difficult
     */
    EASY_UP(10),
    
    /**
     * level of difficult
     */
    NORMAL(20),
    
    /**
     * level of difficult
     */
    DIFFICULT(30),
    
    /**
     * level of difficult
     */
    LEGEND(40);
    
    private final int numb;

    GameStep(int numb) {
        this.numb = numb;
    }

    public int getNumb() {
        return this.numb;
    }
    

}
