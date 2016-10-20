package de.walled.mvvmtest;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import de.walled.mvvmtest.databinding.ActivityMainBinding;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_DTO = "dto.main";

    private MainViewModel viewModel;
	private Subscription fakeLoader = Subscriptions.unsubscribed();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupViewModel(savedInstanceState);
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
        MainDto saveData = viewModel.getTransportData();
        outState.putSerializable(KEY_DTO, saveData);
    }

    private void setupViewModel(Bundle savedState) {
		viewModel = new MainViewModel();

		if (savedState == null) {
			makeInitialNetworkCall();
		} else {
			initFromBundle(savedState);
		}
    }

    private void initFromBundle(Bundle savedState) {
        MainDto transportObject = (MainDto) savedState.getSerializable(KEY_DTO);

        if (transportObject != null) {
			viewModel.initFromSavedState(transportObject);
        } else {
			makeInitialNetworkCall();
		}

    }

	private void makeInitialNetworkCall() {
		fakeLoader = viewModel.loadData().subscribe();
	}
}
