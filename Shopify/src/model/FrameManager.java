package model;

public class FrameManager {

    private static FrameManager frameManager_instance = null;
    private FrameManager(){};
    public static FrameManager getInstance(){
        if(frameManager_instance == null)
            frameManager_instance = new FrameManager();
        return  frameManager_instance;
    }

    public void moveToLoginPage(){
    	
    }
    
    public void moveToChangePasswordPage(){}
    
    public void moveToEmpMainMenuPage(){
    	
    }
    
    public void moveToManagerMainMenuPage(){
    	
    }
    
    public void moveToOrderPage(){}
    public void moveToEmpProductsPage(){}
    public void moveToManagerProductsPage(){}
    public void moveToManageEmpPage(){}

}

