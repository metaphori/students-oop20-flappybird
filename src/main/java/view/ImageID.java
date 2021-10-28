package view;

/**
 * Enumeration for all the Image in the res folder.
 *
 */
public enum ImageID {

    /**
     * background type.
     */
    PLAYING_BACKGROUND("game_background.png"),

    /**
     * gameObject type.
     */
    DOWN_COLUMN("column_down.png"),

    /**
     * gameObject type.
     */
    UP_COLUMN("column_up.png"),

    /**
     * background type.
     */
    FINISH("finish_data.png"),

    /**
     * background type.
     */
    GAME_OVER_ICON("gameover.png"),

    /**
     * gameObject type.
     */
    LASER("laser.png"),

    /**
     * background type.
     */
    LEADERBOARD_BACKGROUND("leaderboard_background.png"),

    /**
     * background type.
     */
    LEADERBOARD_BUTTON("leaderboard.png"),

    /**
     * background type.
     */
    PLAY_BUTTON("play.png"),

    /**
     * background type.
     */
    MENU_BACKGROUND("background_menu.png"),

    /**
     * image type.
     */
    PLAYER_ONE_BUTTON("player.png"),

    /**
     * image type.
     */
    PLAYER_TWO_BUTTON("player2.png"),

    /**
     * image type.
     */
    PLAYER_THREE_BUTTON("player3.png");

    private final String path;

    ImageID(String string) {      
        this.path = string;
    }

    /**
     * @return the path og the images
     */
    public String getPath() {
        return this.path;
    }
}
