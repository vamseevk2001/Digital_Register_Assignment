package vamsee.application.digitalregisterassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class SellActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        Date currentDate = new Date(System.currentTimeMillis());
        TextView time, date;
        time = findViewById(R.id.SellingTime);
        date = findViewById(R.id.SellingDate);
        date.setText(currentDate.getDate()+"/"+currentDate.getMonth()+"/"+currentDate.getYear());
        time.setText(currentDate.getHours()+":"+currentDate.getMinutes());
    }

    public void Save(View view) {
        
    }
}