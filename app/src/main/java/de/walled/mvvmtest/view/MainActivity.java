package de.walled.mvvmtest.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import de.walled.mvvmtest.R;
import de.walled.mvvmtest.api.ClickerApi;
import de.walled.mvvmtest.api.IClickerApi;
import de.walled.mvvmtest.databinding.ActivityMainBinding;
import de.walled.mvvmtest.model.ClickerModel;
import de.walled.mvvmtest.viewmodel.ClickerViewModel;
import de.walled.mvvmtest.viewmodel.ViewState;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class MainActivity extends AppCompatActivity {

	private static final String KEY_VIEW_STATE = "state.view";

	private ClickerViewModel viewModel;
	private Subscription fakeLoader = Subscriptions.unsubscribed();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// would usually be injected but I feel Dagger would be out of scope
		final IClickerApi api = new ClickerApi();
		setupViewModel(savedInstanceState, api);

		ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
		binding.setViewModel(viewModel);
	}

	@Override
	protected void onPause() {
		fakeLoader.unsubscribe();
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		fakeLoader.unsubscribe();
		super.onDestroy();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putSerializable(KEY_VIEW_STATE, viewModel.getViewState());
	}

	private void setupViewModel(Bundle savedInstance, IClickerApi api) {
		viewModel = new ClickerViewModel(new ClickerModel(), api);
		final ViewState savedState = getViewStateFromBundle(savedInstance);

		if (savedState == null) {
			fakeLoader = viewModel.loadData().subscribe();
		} else {
			viewModel.initFromSavedState(savedState);
		}
	}

	private ViewState getViewStateFromBundle(Bundle savedInstance) {
		if (savedInstance != null) {
			return (ViewState) savedInstance.getSerializable(KEY_VIEW_STATE);
		}
		return null;
	}
}
