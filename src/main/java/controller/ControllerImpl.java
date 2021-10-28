package controller;

import java.util.List;
import java.util.Optional;
import model.Bird;
import model.Column;
import model.Model;
import model.ModelImp;
import view.View;
import view.ViewImpl;

public class ControllerImpl implements Controller {

    private GameState gameState;
    private Model model;
    private View view;
    private Integer score;
    private boolean jump;
    private ControllerLeaderBoard clb;
 
    public ControllerImpl(final ViewImpl view) {
        this.view = view;
        this.model = new ModelImp(this);
        this.clb = new ControllerLeaderBoardImpl(model);
        this.gameState = GameState.INITIALIZE;
        this.jump = false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateState() {
        switch (gameState) {
        case GAME_OVER: 
          this.model.gameOver(this.score);
          this.view.gameOver(topScorer());
            break;
        case INITIALIZE:
            this.model.startGame();
            break;
        default:
            break;
        }
    }

    private Optional<Integer> topScorer() {
        Optional<Integer> topScor = this.model.getLeaderboard().stream()
                .map(a -> a.getScore()).map(a -> Integer.parseInt(a)).max((a, b) -> a - b);
        return topScor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setState(final GameState state) {
        this.gameState = state;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void render(final List<Column> list, final Integer score, final Bird bird) {       
           this.score = score;
           this.view.render(list, score, bird);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getGameHeight() {
        return this.model.getGameHeight();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getGameWidth() {
        return this.model.getGameWeidth();
    }
 
    /**
     * {@inheritDoc}
     */
    @Override
    public void checkInput() {
        this.view.checkInput();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameState getState() {
        // TODO Auto-generated method stub
        return this.gameState;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean jump() {
        return this.jump;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setJump(final boolean input) {
        this.jump = input;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ControllerLeaderBoard getLeaderBoardController() {
        return this.clb;
    }
 }



