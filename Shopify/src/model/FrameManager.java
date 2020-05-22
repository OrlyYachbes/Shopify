package model;

import controller.EmpMainMenuController;
import controller.LogInController;
import controller.ManagerMainMenuController;
import view.EmpMainMenuView;
import view.LogInView;
import view.ManagerMainMenuView;

public class FrameManager {

	private boolean manager;
    private static FrameManager frameManager_instance = null;
    private FrameManager(){};
    public static FrameManager getInstance(){
        if(frameManager_instance == null)
            frameManager_instance = new FrameManager();
        return  frameManager_instance;
    }
    
    public void setManager(boolean isManager) {
    	this.manager = isManager;
    }

    public void moveToLoginPage(){
    	LogInView view = new LogInView();
    	LogInModel model = new LogInModel();
    	new LogInController(view, model);
    	view.setVisible(true);
    }
    
    
    public void moveToEmpMainMenuPage(){
    	EmpMainMenuView view = new EmpMainMenuView();
    	EmpMainMenuModel model = new EmpMainMenuModel();
    	new EmpMainMenuController(view, model);
    	view.setVisible(true);	   	
    	
    }
    
    public void moveToManagerMainMenuPage(){
    	ManagerMainMenuView view = new ManagerMainMenuView();
    	ManagerMainMenuModel model = new ManagerMainMenuModel();
    	new ManagerMainMenuController(view, model);
    	view.setVisible(true);	
    }
    
    public void moveToOrderPage(){}
    
    public void moveToEmpProductsPage(){}
    
    public void moveToManagerProductsPage(){}
    
    public void moveToManageEmpPage(){}
    
    public void moveToChangePasswordPage(){}
    
    public void moveToMainMenu() {
    	if(this.manager) {
    		this.moveToManagerMainMenuPage();
    	}
    	else {
    		this.moveToEmpMainMenuPage();
    	}
    }

}

