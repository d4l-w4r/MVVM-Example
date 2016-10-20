package de.walled.mvvmtest;


public class MainModel {

	private int numberOfClicks;
	private Excitement stateOfExcitement;

	public MainModel(MainDto dto) {
		numberOfClicks = dto.getNumberOfClicks();
		stateOfExcitement = dto.getStateOfExcitement();
	}

	public void incrementClicks() {
		numberOfClicks += 1;
		updateStateOfExcitement();
	}

	public int getNumberOfClicks() {
		return numberOfClicks;
	}

	public Excitement getStateOfExcitement() {
		return stateOfExcitement;
	}

	public MainDto getTransportData() {
		MainDto transportObject = new MainDto();
		transportObject.setNumberOfClicks(numberOfClicks);
		transportObject.setStateOfExcitement(stateOfExcitement);
		return transportObject;
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

	public enum Excitement {
		BOO,
		MEH,
		WOOHOO
	}
}
