package de.walled.mvvmtest;

import org.junit.Before;

import static org.junit.Assert.*;


public class MainModelTest {

	private MainModel testee;

	@Before
	public void setup() {
		MainDto dto = new MainDto();
		dto.setNumberOfClicks(0);
		dto.setStateOfExcitement(MainModel.Excitement.BOO);
		testee = new MainModel(dto);
	}

}