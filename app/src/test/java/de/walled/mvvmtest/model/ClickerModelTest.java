package de.walled.mvvmtest.model;

import org.junit.Test;

import de.walled.mvvmtest.viewmodel.ViewState;

import static org.junit.Assert.assertEquals;


public class ClickerModelTest {

	@Test
	public void Given_a_clean_state_when_nothing_is_done_then_counter_is_0_and_excitement_is_boo() {
		// given
		ClickerModel testModel = new ClickerModel();
		final int expectedClicks = 0;
		final Excitement expectedExcitement = Excitement.BOO;

		// when
		final int resultClicks = testModel.getNumberOfClicks();
		final Excitement resultExcitement = testModel.getStateOfExcitement();

		// then
		assertEquals(expectedClicks, resultClicks);
		assertEquals(expectedExcitement, resultExcitement);
	}

	@Test
	public void Given_a_restored_state_when_nothing_is_done_then_counter_and_excitement_matches_restored_state() {
		// given
		final int expectedClicks = 15;
		final Excitement expectedExcitement = Excitement.MEH;

		ViewState viewState = new ViewState();
		viewState.setNumberOfClicks(expectedClicks);
		ClickerModel testModel = new ClickerModel();
		testModel.restoreState(viewState);

		// when
		final int resultClicks = testModel.getNumberOfClicks();
		final Excitement resultExcitement = testModel.getStateOfExcitement();

		// then
		assertEquals(expectedClicks, resultClicks);
		assertEquals(expectedExcitement, resultExcitement);
	}

	@Test
	public void Given_a_clean_state_when_incrementClicks_is_called_once_then_counter_is_1() {
		// given
		ClickerModel testModel = new ClickerModel();
		final int expectedClicks = 1;

		// when
		testModel.incrementClicks();
		final int resultClicks = testModel.getNumberOfClicks();

		// then
		assertEquals(expectedClicks, resultClicks);
	}

	@Test
	public void Given_a_restored_state_when_incrementClicks_is_called_once_then_state_is_updated_correctly() {
		// given
		final int restoredClicks = 1;
		final int expectedClicks = 2;
		final Excitement expectedExcitement = Excitement.BOO;

		ViewState viewState = new ViewState();
		viewState.setNumberOfClicks(restoredClicks);
		ClickerModel testModel = new ClickerModel();
		testModel.restoreState(viewState);

		// when
		testModel.incrementClicks();
		final int resultClicks = testModel.getNumberOfClicks();
		final Excitement resultExcitement = testModel.getStateOfExcitement();

		// then
		assertEquals(expectedClicks, resultClicks);
		assertEquals(expectedExcitement, resultExcitement);
	}

	@Test
	public void Given_a_clean_state_when_incrementClicks_is_called_9_times_then_counter_is_9_and_excitement_is_boo() {
		// given
		ClickerModel testModel = new ClickerModel();
		final int expectedClicks = 9;
		final Excitement expectedExcitement = Excitement.BOO;

		// when
		for (int i = 0; i < expectedClicks; i++) {
			testModel.incrementClicks();
		}
		final int resultClicks = testModel.getNumberOfClicks();
		final Excitement resultExcitement = testModel.getStateOfExcitement();

		// then
		assertEquals(expectedClicks, resultClicks);
		assertEquals(expectedExcitement, resultExcitement);
	}

	@Test
	public void Given_a_clean_state_when_incrementClicks_is_called_10_times_then_counter_is_10_and_excitement_is_meh() {
		// given
		ClickerModel testModel = new ClickerModel();
		final int expectedClicks = 10;
		final Excitement expectedExcitement = Excitement.MEH;

		// when
		for (int i = 0; i < expectedClicks; i++) {
			testModel.incrementClicks();
		}
		final int resultClicks = testModel.getNumberOfClicks();
		final Excitement resultExcitement = testModel.getStateOfExcitement();

		// then
		assertEquals(expectedClicks, resultClicks);
		assertEquals(expectedExcitement, resultExcitement);
	}

	@Test
	public void Given_a_clean_state_when_incrementClicks_is_called_20_times_then_counter_is_20_and_excitement_is_meh() {
		// given
		ClickerModel testModel = new ClickerModel();
		final int expectedClicks = 20;
		final Excitement expectedExcitement = Excitement.MEH;

		// when
		for (int i = 0; i < expectedClicks; i++) {
			testModel.incrementClicks();
		}
		final int resultClicks = testModel.getNumberOfClicks();
		final Excitement resultExcitement = testModel.getStateOfExcitement();

		// then
		assertEquals(expectedClicks, resultClicks);
		assertEquals(expectedExcitement, resultExcitement);
	}

	@Test
	public void Given_a_clean_state_when_incrementClicks_is_called_21_times_then_counter_is_21_and_excitement_is_woohoo() {
		// given
		ClickerModel testModel = new ClickerModel();
		final int expectedClicks = 21;
		final Excitement expectedExcitement = Excitement.WOOHOO;

		// when
		for (int i = 0; i < expectedClicks; i++) {
			testModel.incrementClicks();
		}
		final int resultClicks = testModel.getNumberOfClicks();
		final Excitement resultExcitement = testModel.getStateOfExcitement();

		// then
		assertEquals(expectedClicks, resultClicks);
		assertEquals(expectedExcitement, resultExcitement);
	}
}