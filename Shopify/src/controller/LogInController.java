package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LogInModel;
import view.LogInView;

public class LogInController {
	private LogInView view;
	private LogInModel model;
	
	public LogInController(LogInView view, LogInModel model) {
		this.view = view;
		this.model = model;
		view.setLogInAL(new LogInBtnActionListener());
	}
	
	class LogInBtnActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String userName = view.getUserName();
			String pass = view.getPass();
			
			if(userName.trim().equals("") || pass.trim().equals("")) {
				view.displayMessage("You must enter a value for both username and password");
				return;
			}
			
			
		if(model.logIn(userName, pass) == false) {
				view.displayMessage("User name or password is incorrect");
			}
		else {
			view.setVisible(false);
			view.dispose();
		}
			
			
		}
	}
}
