package de.walled.mvvmtest.model;


import com.google.common.base.Optional;

import de.walled.mvvmtest.viewmodel.ViewState;

public class ClickerModel implements Clicker {

	private int numberOfClicks;
	private Excitement stateOfExcitement;

	public void incrementClicks() {
		numberOfClicks += 1;
		updateStateOfExcitement();
	}

	public int getNumberOfClicks() {
		return Optional.fromNullable(numberOfClicks).or(0);
	}

	public Excitement getStateOfExcitement() {
		return Optional.fromNullable(stateOfExcitement).or(Excitement.BOO);
	}

	public void restoreState(ViewState state) {
		numberOfClicks = state.getNumberOfClicks();
		updateStateOfExcitement();
	}

	private void updateStateOfExcitement() {
		if (numberOfClicks < 10) {
			stateOfExcitement = Excitement.BOO;
		} else if (numberOfClicks <= 20) {
			stateOfExcitement = Excitement.MEH;
		} else {
			stateOfExcitement = Excitement.WOOHOO;
		}
	}
}
