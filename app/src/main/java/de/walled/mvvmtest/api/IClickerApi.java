package de.walled.mvvmtest.api;

import de.walled.mvvmtest.viewmodel.ViewState;
import rx.Observable;

public interface IClickerApi {

	Observable<ViewState> fetchInitialState();
}
