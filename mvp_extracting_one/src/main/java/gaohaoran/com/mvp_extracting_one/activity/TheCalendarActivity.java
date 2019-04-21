package gaohaoran.com.mvp_extracting_one.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Date;

import gaohaoran.com.mvp_extracting_one.R;

public class TheCalendarActivity extends AppCompatActivity {

    private MaterialCalendarView mcv;
    /**
     * 确定
     */
    private TextView tv_ok;
    private String format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thecalendar);
        initView();
    }

    private void initView() {
        mcv = (MaterialCalendarView) findViewById(R.id.mcv);
        tv_ok = (TextView) findViewById(R.id.tv_ok);

        mcv.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Date date1 = date.getDate();
                SimpleDateFormat ymd = new SimpleDateFormat("yymmdd");
                format = ymd.format(date1);
            }
        });
        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(format);
                finish();
            }
        });
    }
}
