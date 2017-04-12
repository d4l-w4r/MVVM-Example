package de.walled.mvvmtest.api;

import java.util.concurrent.TimeUnit;

import de.walled.mvvmtest.viewmodel.ViewState;
import rx.Observable;

public class ClickerController {

	public Observable<ViewState> fetchInitialState() {
		return Observable.fromCallable(this::fakeNetworkCall)
				.delay(3, TimeUnit.SECONDS);
	}

	private ViewState fakeNetworkCall() {
		ViewState remotelyStoredState = new ViewState();
		remotelyStoredState.setNumberOfClicks(0);
		return remotelyStoredState;
	}
}
