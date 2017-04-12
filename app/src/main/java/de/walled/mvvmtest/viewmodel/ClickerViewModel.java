package de.walled.mvvmtest.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;

import com.android.databinding.library.baseAdapters.BR;

import de.walled.mvvmtest.R;
import de.walled.mvvmtest.api.ClickerController;
import de.walled.mvvmtest.model.Excitement;
import de.walled.mvvmtest.model.Clicker;
import rx.Observable;

public class ClickerViewModel extends BaseObservable {

	private final ClickerController api;
	boolean isLoading = false;
	private Clicker model;

	public ClickerViewModel(Clicker model, ClickerController api) {
		this.model = model;
		this.api = api;
	}

	public void onClickIncrement() {
		model.incrementClicks();
		notifyChange();
	}

	public ViewState getViewState() {
		ViewState viewState = new ViewState();
		viewState.setNumberOfClicks(model.getNumberOfClicks());
		return viewState;
	}

	public Observable<ViewState> loadData() {
		isLoading = true;
		return api.fetchInitialState()
				.doOnNext(this::initModel)
				.doOnTerminate(() -> {
					isLoading = false;
					notifyPropertyChanged(BR.loadingVisible);
					notifyPropertyChanged(BR.contentVisible);
				});
	}

	public void initFromSavedState(ViewState savedState) {
		initModel(savedState);
	}

	@Bindable
	public String getNumberOfClicks() {
		final int clicks = model.getNumberOfClicks();
		return String.valueOf(clicks);
	}

	@Bindable
	@StringRes
	public int getLabelText() {
		final Excitement stateOfExcitement = model.getStateOfExcitement();
		return resolveLabelText(stateOfExcitement);
	}

	@Bindable
	@ColorRes
	public int getCounterColor() {
		final Excitement stateOfExcitement = model.getStateOfExcitement();
		return resolveCounterColor(stateOfExcitement);
	}

	@Bindable
	public boolean isLoadingVisible() {
		return isLoading;
	}

	@Bindable
	public boolean isContentVisible() {
		return !isLoading;
	}

	private void initModel(final ViewState viewState) {
		model.restoreState(viewState);
		notifyChange();
	}

	@ColorRes
	private int resolveCounterColor(Excitement stateOfExcitement) {
		switch (stateOfExcitement) {
			case MEH:
				return R.color.yellow;
			case WOOHOO:
				return R.color.green;
			default:
				return R.color.red;
		}
	}

	@StringRes
	private int resolveLabelText(Excitement stateOfExcitement) {
		switch (stateOfExcitement) {
			case MEH:
				return R.string.label_indifferent;
			case WOOHOO:
				return R.string.label_excited;
			default:
				return R.string.label_negative;
		}
	}

}
