package model;

import controller.EmpMainMenuController;
import controller.EmpMainMenuController;
import controller.EmpProductsPageController;
import controller.LogInController;
import controller.ManagerEmployeesPageController;
//import controller.ManagerEmployeesPageController;
import controller.ManagerMainMenuController;
import controller.ManagerProductsPageController;
//import controller.ManagerProductsPageController;
import controller.OrderPageController;
import view.EmpMainMenuView;
import view.EmpProductsPageView;
import view.LogInView;
import view.ManagerEmployeesPageView;
//import view.ManagerEmployeesPageView;
import view.ManagerMainMenuView;
import view.ManagerProductsPageView;
//import view.ManagerProductsPageView;
import view.OrderPageView;

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
    	LogInController controller = new LogInController(view, model);
    	view.setVisible(true);
    }
    
    
    public void moveToEmpMainMenuPage(){
    	EmpMainMenuView view = new EmpMainMenuView();
    	EmpMainMenuModel model = new EmpMainMenuModel();
    	EmpMainMenuController controller = new EmpMainMenuController(view, model);
    	view.setVisible(true);	   	
    	
    }
    
    public void moveToManagerMainMenuPage(){
    	ManagerMainMenuView view = new ManagerMainMenuView();
    	ManagerMainMenuModel model = new ManagerMainMenuModel();
    	ManagerMainMenuController controller = new ManagerMainMenuController(view, model);
    	view.setVisible(true);	
    }
    
    public void moveToOrderPage(){
    	OrderPageView view = new OrderPageView();
    	OrderPageModel model = new OrderPageModel();
    	new OrderPageController(view, model);
    	view.setVisible(true);
    	
    }
    
    public void moveToEmpProductsPage(){
    	EmpProductsPageView view = new EmpProductsPageView();
    	EmpProductsPageModel model = new EmpProductsPageModel();
    	new EmpProductsPageController(view, model);
    	view.setVisible(true);
    }
    
    public void moveToManagerProductsPage(){
    	ManagerProductsPageView view = new ManagerProductsPageView();
    	ManagerProductsPageModel model = new ManagerProductsPageModel();
    	new ManagerProductsPageController(view, model);
    	view.setVisible(true);
    }
    
    public void moveToManageEmpPage(){
    	ManagerEmployeesPageView view = new ManagerEmployeesPageView();
    	ManagerEmployeesPageModel model = new ManagerEmployeesPageModel();
    	new ManagerEmployeesPageController(view, model);
    	view.setVisible(true);
    }
    
    
    public void moveToMainMenuPage() {
    	if(this.manager) {
    		this.moveToManagerMainMenuPage();
    	}
    	else {
    		this.moveToEmpMainMenuPage();
    	}
    }

}

