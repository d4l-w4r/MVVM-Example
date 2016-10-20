package de.walled.mvvmtest.viewmodel;

import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.concurrent.TimeUnit;

import de.walled.mvvmtest.R;
import de.walled.mvvmtest.api.IClickerApi;
import de.walled.mvvmtest.model.ClickerModel;
import rx.Observable;
import rx.observers.TestSubscriber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;


public class ClickerViewModelTest {

	IClickerApi api;
	ClickerViewModel testViewModel;

	@Before
	public void setup() {
		api = mock(IClickerApi.class);
		testViewModel = new ClickerViewModel(new ClickerModel(), api);
	}

	@Test
	public void Given_a_fresh_setup_when_nothing_is_done_then_getNumberOfClicks_returns_0() {
		// given
		final String expectedResult = "0";

		// when
		final String result = testViewModel.getNumberOfClicks();

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
			testViewModel.onClickIncrement();
		}
		final String result = testViewModel.getNumberOfClicks();

		// then
		assertEquals(expectedResult, result);
	}

	@Test
	public void Given_a_fresh_setup_when_nothing_is_done_then_getCounterColor_returns_Red() {
		// given
		@ColorRes final int expectedResult = R.color.red;

		// when
		@ColorRes final int result = testViewModel.getCounterColor();

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
			testViewModel.onClickIncrement();
		}
		@ColorRes final int result = testViewModel.getCounterColor();

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
			testViewModel.onClickIncrement();
		}
		@ColorRes final int result = testViewModel.getCounterColor();

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
			testViewModel.onClickIncrement();
		}
		@ColorRes final int result = testViewModel.getCounterColor();

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
			testViewModel.onClickIncrement();
		}
		@ColorRes final int result = testViewModel.getCounterColor();

		// then
		assertEquals(expectedResult, result);
	}

	@Test
	public void	Given_a_fresh_setup_when_nothing_is_done_getLabelText_returns_negative_string() {
		// given
		@StringRes final int expectedResult = R.string.label_negative;

		// when
		@StringRes final int result = testViewModel.getLabelText();

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
			testViewModel.onClickIncrement();
		}
		@StringRes final int result = testViewModel.getLabelText();

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
			testViewModel.onClickIncrement();
		}
		@StringRes final int result = testViewModel.getLabelText();

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
			testViewModel.onClickIncrement();
		}
		@StringRes final int result = testViewModel.getLabelText();

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
			testViewModel.onClickIncrement();
		}
		@StringRes final int result = testViewModel.getLabelText();

		// then
		assertEquals(expectedResult, result);
	}

	@Test
	public void Given_a_fresh_setup_when_getViewState_is_called_then_clicks_in_view_state_are_0() {
		// given
		final int expectedClicks = 0;

		// when
		final ViewState viewState = testViewModel.getViewState();

		// then
		assertEquals(expectedClicks, viewState.getNumberOfClicks());
	}

	@Test
	public void Given_a_state_after_5_clicks_when_getViewState_is_called_then_clicks_in_view_state_are_5() {
		// given
		final int expectedClicks = 5;
		for (int i = 0; i < expectedClicks; i++) {
			testViewModel.onClickIncrement();
		}

		// when
		final ViewState viewState = testViewModel.getViewState();

		// then
		assertEquals(expectedClicks, viewState.getNumberOfClicks());
	}

	@Test
	public void Given_a_restored_state_when_initFromSavedState_is_called_clicks_match_state() {
		// given
		final int storedClicks = 36;
		final String expectedResult = "36";
		ViewState stateToRestore = new ViewState();
		stateToRestore.setNumberOfClicks(storedClicks);

		// when
		testViewModel.initFromSavedState(stateToRestore);
		final String resultClicks = testViewModel.getNumberOfClicks();

		// then
		assertEquals(expectedResult, resultClicks);
	}

	@Test
	public void Given_that_isLoading_is_set_to_true_isLoadingVisible_returns_true_isContentVisible_returns_false() {
		// given
		testViewModel.isLoading = true;

		// when
		final boolean loadingVisible = testViewModel.isLoadingVisible();
		final boolean contentVisible = testViewModel.isContentVisible();

		// then
		assertTrue(loadingVisible);
		assertFalse(contentVisible);
	}

	@Test
	public void Given_that_isLoading_is_set_to_false_isLoadingVisible_returns_true_isContentVisible_returns_false() {
		// given
		testViewModel.isLoading = false;

		// when
		final boolean loadingVisible = testViewModel.isLoadingVisible();
		final boolean contentVisible = testViewModel.isContentVisible();

		// then
		assertFalse(loadingVisible);
		assertTrue(contentVisible);
	}

	@Test
	public void Given_a_fresh_setup_when_loadData_is_called_then_model_is_initialized() {
		// given
		ViewState fetchedState = new ViewState();
		fetchedState.setNumberOfClicks(0);
		final String expectedResults = "0";
		TestSubscriber<ViewState> testSubscriber = new TestSubscriber<>();

		when(api.fetchInitialState()).thenReturn(Observable.just(fetchedState));

		// when
		testViewModel.loadData().subscribe(testSubscriber);
		testSubscriber.awaitTerminalEvent();
		final String clickCount = testViewModel.getNumberOfClicks();

		// then
		testSubscriber.assertValue(fetchedState);
		assertEquals(expectedResults, clickCount);
		verify(api).fetchInitialState();
		verifyNoMoreInteractions(api);
	}
}