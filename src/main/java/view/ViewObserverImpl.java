package view;

import controller.Controller;

public class ViewObserverImpl implements ViewObserver {

    private Controller controller;
    
    public ViewObserverImpl(Controller controller) {
        this.controller = controller;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void pressSpace() {
        // TODO Auto-generated method stub
        this.controller.setJump(true);
    }

}
