package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.AppFrame;

public class PlaceBetListener implements ActionListener {

	private AppFrame appFrame;
	private GameEngine gameEngine;

	public PlaceBetListener( GameEngine gameEngine, AppFrame appFrame) {
		this.gameEngine = gameEngine;
		this.appFrame = appFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//place bet for selected player and update status bar
		Player player = appFrame.getSelectedPlayer(gameEngine);
		appFrame.placeBet(gameEngine, player);
		appFrame.setStatus(gameEngine);
	}

}
