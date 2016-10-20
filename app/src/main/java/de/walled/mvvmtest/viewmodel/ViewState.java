package de.walled.mvvmtest.viewmodel;

import java.io.Serializable;

public class ViewState implements Serializable {

	private int numberOfClicks;

	public int getNumberOfClicks() {
		return numberOfClicks;
	}

	public void setNumberOfClicks(int numberOfClicks) {
		this.numberOfClicks = numberOfClicks;
	}

}
