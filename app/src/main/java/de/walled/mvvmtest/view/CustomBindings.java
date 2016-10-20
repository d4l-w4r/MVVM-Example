package de.walled.mvvmtest.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.databinding.BindingAdapter;
import android.os.Build;
import android.widget.TextView;

public class CustomBindings {

	@TargetApi(23)
	@BindingAdapter({"bind:textColor"})
	public static void setTextColor(TextView textView, int colorResId) {
		final Context context = textView.getContext();
		final Resources resources = context.getResources();
		final int apiVersion = Build.VERSION.SDK_INT;
		int color;

		if (apiVersion >= Build.VERSION_CODES.M) {
			color = resources.getColor(colorResId, context.getTheme());
		} else {
			color = resources.getColor(colorResId);
		}

		textView.setTextColor(color);
	}
}
