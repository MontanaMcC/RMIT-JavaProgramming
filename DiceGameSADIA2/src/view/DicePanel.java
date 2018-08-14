package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.DicePairImpl;
import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class DicePanel extends JPanel {
	private JLabel Dice1 = new JLabel("Dice1: ");
	private JLabel Dice2 = new JLabel("Dice2: ");
	private JLabel Sum = new JLabel("Sum: ");
	private JLabel HouseDice1 = new JLabel("House Dice1: ");
	private JLabel HouseDice2 = new JLabel("House Dice2: ");
	private JLabel HouseSum = new JLabel("House Sum: ");
	private JLabel Result = new JLabel("Result: ");

	public DicePanel(GameEngine gameEngine, AppFrame frame) {
		setLayout(new GridLayout(3, 2));

		add(Dice1);
		add(Dice2);
		add(Sum);
		add(HouseDice1);
		add(HouseDice2);
		add(HouseSum);
		add(Result);
	}
	
	public void updatePanel(Player player, DicePair dicePair) {
		//if player has not rolled yet then roll for them
		if (player.getRollResult() == null) {
			int dice1 = 0;
			int dice2 = 0;
			DicePair dice = new DicePairImpl(dice1, dice2, 6);
			player.setRollResult(dice);

			Dice1.setText("Dice1: " + dice1);
			Dice2.setText("Dice2: " + dice2);
			Sum.setText("Sum: " + (dice1 + dice2));
			resetHouse();
		}
		else if (player.getRollResult() != null) {
			int dice1 = dicePair.getDice1();
			int dice2 = dicePair.getDice2();
			int sum = dice1 + dice2;
			Dice1.setText("Dice1: " + dice1);
			Dice2.setText("Dice2: " + dice2);
			Sum.setText("Sum: " + sum);
		}
		
		if (Integer.parseInt(HouseSum.getText().substring(10)) != 0) {
			updateResult();
		} else if (Integer.parseInt(HouseSum.getText().substring(10)) == 0 && Integer.parseInt(Sum.getText().substring(5)) == 0) {
			Result.setText("Result: ");
		}

	}
	
	public void updateHouse(DicePair dicePair) {
		int dice1 = dicePair.getDice1();
		int dice2 = dicePair.getDice2();
		int sum = dice1 + dice2;
		HouseDice1.setText("HouseDice1: " + dice1);
		HouseDice2.setText("HouseDice2: " + dice2);
		HouseSum.setText("HouseSum: " + sum);
		updateResult();

	}
	
	public void updateResult() {
		String result = "";
		if (Integer.parseInt(Sum.getText().substring(5)) > Integer.parseInt(HouseSum.getText().substring(10))) {
			result = "Win!";
			Result.setText("Result: " + result);
		} else if (Integer.parseInt(Sum.getText().substring(5)) < Integer.parseInt(HouseSum.getText().substring(10))) {
			result = "Lost!";
			Result.setText("Result: " + result);
		} else if (Integer.parseInt(Sum.getText().substring(5)) == Integer.parseInt(HouseSum.getText().substring(10))) {
			result = "Draw";
			Result.setText("Result: " + result);
		}
	}
	
	public void resetHouse() {
		HouseDice1.setText("HouseDice1: 0");
		HouseDice2.setText("HouseDice2: 0");
		HouseSum.setText("HouseSum: 0");
	}
}
