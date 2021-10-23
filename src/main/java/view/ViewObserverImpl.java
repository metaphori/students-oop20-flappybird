package view;

import controller.Controller;

public class ViewObserverImpl implements ViewObserver {

    private Controller controller;
    
    public ViewObserverImpl(Controller controller) {
        // TODO Auto-generated constructor stub
        this.controller = controller;
    }

    @Override
    public void pressSpace() {
        // TODO Auto-generated method stub
        this.controller.setJump(true);
    }

}
