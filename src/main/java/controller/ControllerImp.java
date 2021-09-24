package controller;

public class ControllerImp implements Controller{

    @Override
    public void mainLoop() {
        // TODO Auto-generated method stub
        while(true) {
            processInput();
            
            update();
            
            render();
            
        }
    }

    @Override
    public void processInput() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void render() {
        // TODO Auto-generated method stub
        
    }

}
