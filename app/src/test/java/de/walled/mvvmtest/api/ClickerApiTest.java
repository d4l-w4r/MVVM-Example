package de.walled.mvvmtest.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ClickerApiTest {

	ClickerApi testApi;

	@Before
	public void setup() {
		testApi = new ClickerApi();
	}

	@Test
	public void Given_my_fake_api_when_fetchInitialState_is_called_number_of_clicks_is_0() {
		testApi.fetchInitialState()
				.doOnNext(state -> assertEquals(0, state.getNumberOfClicks()))
				.toCompletable()
				.await();
	}
}