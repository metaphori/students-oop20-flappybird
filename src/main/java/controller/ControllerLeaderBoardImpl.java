package controller;

import java.util.List;

import model.Model;
import model.file.Gamer;
import model.file.LeaderBoard;

public class ControllerLeaderBoardImpl implements ControllerLeaderBoard {

    private Model model;
    
    public ControllerLeaderBoardImpl(Model model) {
        this.model = model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Gamer> getLeaderBoard() {
        return this.model.getLeaderboard();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void savePlayer(String name) {
        this.model.addPlayer(name);

    }

}
