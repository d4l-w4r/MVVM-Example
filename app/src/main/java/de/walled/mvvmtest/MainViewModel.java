package de.walled.mvvmtest;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;

import java.util.concurrent.TimeUnit;

import rx.Observable;

public class MainViewModel extends BaseObservable {

	private MainModel model;
	private boolean isLoading = false;

	public MainViewModel() {
		MainDto dto = new MainDto();
		model = new MainModel(dto);
	}

	public void onClickIncrement() {
		model.incrementClicks();
		notifyChange();
	}


	public MainDto getTransportData() {
		return model.getTransportData();
	}

	public void initFromSavedState(MainDto dto) {
		initModel(dto);
	}

	@Bindable
	public String getNumberOfClicks() {
		final int clicks = model.getNumberOfClicks();
		return String.valueOf(clicks);
	}

	@Bindable
	@StringRes
	public int getLabelText() {
		final MainModel.Excitement stateOfExcitement = model.getStateOfExcitement();
		return resolveLabelText(stateOfExcitement);
	}

	@Bindable
	@ColorRes
	public int getCounterColor() {
		final MainModel.Excitement stateOfExcitement = model.getStateOfExcitement();
		return resolveCounterColor(stateOfExcitement);
	}

	@Bindable
	public boolean isLoading() {
		return isLoading;
	}

	public Observable<MainDto> loadData() {
		isLoading = true;
		return Observable
				.fromCallable(this::fakeANetworkCall)
				.delay(3, TimeUnit.SECONDS)
				.doOnNext(this::initModel)
				.doOnCompleted(() -> isLoading = false);
	}

	private void initModel(MainDto transportObject) {
		this.model = new MainModel(transportObject);
		notifyChange();
	}

	private MainDto fakeANetworkCall() {
		MainDto dto = new MainDto();
		dto.setNumberOfClicks(0);
		dto.setStateOfExcitement(MainModel.Excitement.BOO);
		return dto;
	}

	@ColorRes
	private int resolveCounterColor(MainModel.Excitement stateOfExcitement) {
		if (stateOfExcitement == null) {
			return R.color.red;
		}

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
	private int resolveLabelText(MainModel.Excitement stateOfExcitement) {
		if (stateOfExcitement == null) {
			return R.string.label_negative;
		}

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
