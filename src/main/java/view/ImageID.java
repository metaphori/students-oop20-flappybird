package view;

public enum ImageID {
    
    PLAYING_BACKGROUND("game_background.png"),
    DOWN_COLUMN("column_down.png"),
    UP_COLUMN("column_up.png"),
    FINISH("finish_data.png"),
    GAME_OVER_ICON("gameover.png"),
    LASER("laser.png"),
    LEADERBOARD_BACKGROUND("leaderboard_background.png"),
    LEADERBOARD_BUTTON("leaderboard.png"),
    PLAY_BUTTON("play.png");
    

    private final String path;

    ImageID(String string) {
        
        this.path = string;
    }
    
    public String getPath() {
        
        return this.path;
    }
}
