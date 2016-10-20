package de.walled.mvvmtest.model;


import de.walled.mvvmtest.viewmodel.ViewState;

public interface IClickerModel {

	int getNumberOfClicks();

	Excitement getStateOfExcitement();

	void incrementClicks();

	void restoreState(ViewState state);
}
