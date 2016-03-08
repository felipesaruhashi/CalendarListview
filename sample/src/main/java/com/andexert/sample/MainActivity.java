package com.andexert.sample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.andexert.calendarlistview.library.DayPickerView;
import com.andexert.calendarlistview.library.SimpleMonthAdapter;

import java.util.Calendar;
import java.util.Date;


public class MainActivity extends Activity implements com.andexert.calendarlistview.library.DatePickerController {

    private DayPickerView dayPickerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dayPickerView = (DayPickerView) findViewById(R.id.pickerView);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 28);
        cal.set(Calendar.MONTH, 3);

        dayPickerView.setmStartAvailableDate(cal.getTime());

//        dayPickerView.setmEndAvailableDate(cal.getTime());
        dayPickerView.setController(this);

        ( (Button) findViewById(R.id.btnReset) ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dayPickerView.reset();
            }
        });

        ( (Button) findViewById(R.id.btnScroolFirstSelection) ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dayPickerView.scroolToFirstSelection();
            }
        });
        ( (Button) findViewById(R.id.btnGoFirstAvailableDate) ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dayPickerView.scroolToFirstVisibleDate();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public int getMaxYear() {

        Calendar cal = Calendar.getInstance();

        return 2019;
    }

    @Override
    public void onDayOfMonthSelected(int year, int month, int day)
    {
        Log.e("Day Selected", day + " / " + month + " / " + year);
    }

    @Override
    public void onDateRangeSelected(SimpleMonthAdapter.SelectedDays<SimpleMonthAdapter.CalendarDay> selectedDays)
    {

        Log.e("Date range selected", selectedDays.getFirst().toString() + " --> " + selectedDays.getLast().toString());
    }
}
