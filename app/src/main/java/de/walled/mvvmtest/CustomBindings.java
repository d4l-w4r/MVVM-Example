package de.walled.mvvmtest;

import android.content.res.Resources;
import android.databinding.BindingAdapter;
import android.widget.TextView;

public class CustomBindings {

	@BindingAdapter({"bind:textColor"})
	public static void setTextColor(TextView textView, int colorResId) {
		final Resources resources = textView.getContext().getResources();
		textView.setTextColor(resources.getColor(colorResId));
	}
}
