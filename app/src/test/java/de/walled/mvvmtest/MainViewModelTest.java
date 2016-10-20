package de.walled.mvvmtest;

import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class MainViewModelTest {

	private MainViewModel testee;

	@Before
	public void setup() {
		MainDto dto = new MainDto();
		dto.setNumberOfClicks(0);
		dto.setStateOfExcitement(MainModel.Excitement.BOO);
		final MainModel model = new MainModel(dto);
		testee = new MainViewModel(model);
	}

	@Test
	public void Given_a_fresh_setup_when_nothing_is_done_then_getNumberOfClicks_returns_0() {
		// given
		final String expectedResult = "0";

		// when
		final String result = testee.getNumberOfClicks();

		// then
		assertEquals(expectedResult, result);
	}

	@Test
	public void Given_a_fresh_setup_when_updateCounter_is_called_5_times_then_getNumberOfClicks_returns_5() {
		// given
		final int numberOfClicks = 5;
		final String expectedResult = "5";

		// when
		for (int i = 0; i < numberOfClicks; i++) {
			testee.onClickIncrement();
		}
		final String result = testee.getNumberOfClicks();

		// then
		assertEquals(expectedResult, result);
	}

	@Test
	public void Given_a_fresh_setup_when_nothing_is_done_then_getCounterColor_returns_Red() {
		// given
		@ColorRes final int expectedResult = R.color.red;

		// when
		@ColorRes final int result = testee.getCounterColor();

		// then
		assertEquals(expectedResult, result);
	}

	@Test
	public void Given_a_fresh_setup_when_updateCounter_is_called_9_times_then_getCounterColor_returns_Red() {
		// given
		final int numberOfClicks = 9;
		@ColorRes final int expectedResult = R.color.red;

		// when
		for (int i = 0; i < numberOfClicks; i++) {
			testee.onClickIncrement();
		}
		@ColorRes final int result = testee.getCounterColor();

		// then
		assertEquals(expectedResult, result);
	}

	@Test
	public void Given_a_fresh_setup_when_updateCounter_is_called_10_times_then_getCounterColor_returns_Yellow() {
		// given
		final int numberOfClicks = 10;
		@ColorRes final int expectedResult = R.color.yellow;

		// when
		for (int i = 0; i < numberOfClicks; i++) {
			testee.onClickIncrement();
		}
		@ColorRes final int result = testee.getCounterColor();

		// then
		assertEquals(expectedResult, result);
	}

	@Test
	public void Given_a_fresh_setup_when_updateCounter_is_called_20_times_then_getCounterColor_returns_Yellow() {
		// given
		final int numberOfClicks = 20;
		@ColorRes final int expectedResult = R.color.yellow;

		// when
		for (int i = 0; i < numberOfClicks; i++) {
			testee.onClickIncrement();
		}
		@ColorRes final int result = testee.getCounterColor();

		// then
		assertEquals(expectedResult, result);
	}

	@Test
	public void Given_a_fresh_setup_when_updateCounter_is_called_21_times_then_getCounterColor_returns_Green() {
		// given
		final int numberOfClicks = 21;
		@ColorRes final int expectedResult = R.color.green;

		// when
		for (int i = 0; i < numberOfClicks; i++) {
			testee.onClickIncrement();
		}
		@ColorRes final int result = testee.getCounterColor();

		// then
		assertEquals(expectedResult, result);
	}

	@Test
	public void	Given_a_fresh_setup_when_nothing_is_done_getLabelText_returns_negative_string() {
		// given
		@StringRes final int expectedResult = R.string.label_negative;

		// when
		@StringRes final int result = testee.getLabelText();

		// then
		assertEquals(expectedResult, result);
	}

	@Test
	public void Given_a_fresh_setup_when_updateCounter_is_called_9_times_then_getLabelText_returns_negative_string() {
		// given
		final int numberOfClicks = 9;
		@StringRes final int expectedResult = R.string.label_negative;

		// when
		for (int i = 0; i < numberOfClicks; i++) {
			testee.onClickIncrement();
		}
		@StringRes final int result = testee.getLabelText();

		// then
		assertEquals(expectedResult, result);
	}

	@Test
	public void Given_a_fresh_setup_when_updateCounter_is_called_10_times_then_getLabelText_returns_indifferent_string() {
		// given
		final int numberOfClicks = 10;
		@StringRes final int expectedResult = R.string.label_indifferent;

		// when
		for (int i = 0; i < numberOfClicks; i++) {
			testee.onClickIncrement();
		}
		@StringRes final int result = testee.getLabelText();

		// then
		assertEquals(expectedResult, result);
	}

	@Test
	public void Given_a_fresh_setup_when_updateCounter_is_called_19_times_then_getLabelText_returns_indifferent_string() {
		// given
		final int numberOfClicks = 19;
		@StringRes final int expectedResult = R.string.label_indifferent;

		// when
		for (int i = 0; i < numberOfClicks; i++) {
			testee.onClickIncrement();
		}
		@StringRes final int result = testee.getLabelText();

		// then
		assertEquals(expectedResult, result);
	}

	@Test
	public void Given_a_fresh_setup_when_updateCounter_is_called_21_times_then_getLabelText_returns_excited_string() {
		// given
		final int numberOfClicks = 21;
		@StringRes final int expectedResult = R.string.label_excited;

		// when
		for (int i = 0; i < numberOfClicks; i++) {
			testee.onClickIncrement();
		}
		@StringRes final int result = testee.getLabelText();

		// then
		assertEquals(expectedResult, result);
	}

	@Test
	public void Given_a_fresh_setup_when_nothing_is_done_then_getTransportData_has_initial_values() {
		// given
		final int expectedClicks = 0;
		final MainModel.Excitement expectedExcitement = MainModel.Excitement.BOO;

		// when
		final MainDto result = testee.getTransportData();

		// then
		assertEquals(expectedClicks, result.getNumberOfClicks());
		assertEquals(expectedExcitement, result.getStateOfExcitement());
	}
}