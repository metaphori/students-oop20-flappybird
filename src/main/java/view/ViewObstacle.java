package view;

import java.util.List;

import model.Column;

/**
 * Interface of the viewObstacles
 */
public interface ViewObstacle {
    
    /**
     * Show the columns
     *
     *@param list
     *            the column list
     */
    void render(List<Column> list);

}
