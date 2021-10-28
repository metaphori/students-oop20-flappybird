package model.manager;

import model.Bird;

public interface ManagerJump {

    /**
     * Increase the coordinate y of the bird.
     * @return bird's height.
     */
    double jump(Bird b);
}
