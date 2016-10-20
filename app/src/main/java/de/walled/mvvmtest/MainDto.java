package de.walled.mvvmtest;

import java.io.Serializable;

public class MainDto implements Serializable {

	private int numberOfClicks;
	private MainModel.Excitement stateOfExcitement;

	public int getNumberOfClicks() {
		return numberOfClicks;
	}

	public void setNumberOfClicks(int numberOfClicks) {
		this.numberOfClicks = numberOfClicks;
	}

	public MainModel.Excitement getStateOfExcitement() {
		return stateOfExcitement;
	}

	public void setStateOfExcitement(MainModel.Excitement stateOfExcitement) {
		this.stateOfExcitement = stateOfExcitement;
	}
}
