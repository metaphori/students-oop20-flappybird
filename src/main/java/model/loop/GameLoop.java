package model.loop;

/**
 * The gameloop of the game
 */
import java.util.List;

import model.Bird;
import model.Column;

public interface GameLoop {   
    
    /**
     * @return the list of columns
     */
    List<Column> getColumns();

}
