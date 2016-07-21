package com.ww.frame;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.ww.slidedatetimepicker.SlideDateTimeListener;
import com.ww.slidedatetimepicker.SlideDateTimePicker;

public class MainActivity extends FragmentActivity {
	private SimpleDateFormat mFormatter = new SimpleDateFormat("yyyy年MM月dd日 hh:mm aa");

	private SlideDateTimeListener listener = new SlideDateTimeListener() {
		@Override
		public void onDateTimeSet(Date date) {
			Toast.makeText(MainActivity.this, mFormatter.format(date), Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onDateTimeCancel() {
			Toast.makeText(MainActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.tv).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				new SlideDateTimePicker.Builder(getSupportFragmentManager()).setListener(listener).setInitialDate(new Date()).build().show();
			}
		});
	}
}
