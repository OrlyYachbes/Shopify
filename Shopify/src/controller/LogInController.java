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
			String userName = view.getName();
			String pass = view.getPass();
			
			if(model.logIn(userName, pass) == false) {
				view.displayMessage("User name or password is incorrect");
			}
			
			
		}
	}
}
