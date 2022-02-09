package vamsee.application.digitalregisterassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import vamsee.application.digitalregisterassignment.Model.BodyModel;
import vamsee.application.digitalregisterassignment.Model.UpdateTransaction;

public class SellActivity extends AppCompatActivity {
    TextView time, date, total;
    EditText name, price, unit, qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        Date currentDate = new Date(System.currentTimeMillis());
        time = findViewById(R.id.SellingTime);
        date = findViewById(R.id.SellingDate);
        name = findViewById(R.id.productName);
        price = findViewById(R.id.productPrice);
        unit = findViewById(R.id.units);
        qty = findViewById(R.id.Quantity);
        total = findViewById(R.id.totalAmt);
        date.setText(currentDate.getDate() + "/" + currentDate.getMonth() + "/" + currentDate.getYear());
        time.setText(currentDate.getHours() + ":" + currentDate.getMinutes());

        if (qty.getText().toString() != "" || price.getText().toString() != "")
            total.setText(Integer.parseInt(qty.getText().toString()) * Integer.parseInt(price.getText().toString()));
    }

    public void Save(View view) {
        BodyModel newtxn = new BodyModel(date.getText().toString(),
                time.getText().toString(), name.getText().toString(),
                Integer.parseInt(price.getText().toString()),
                unit.getText().toString(), Integer.parseInt(qty.getText().toString()),
                Integer.parseInt(total.getText().toString()), "sell");


    }


    public void PostOperation() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "http://178e-2405-201-3017-105f-d94b-13a-861e-2a74.ngrok.io/api/createTransaction";


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        BodyModel bodyModel = new GsonBuilder().create().fromJson(response, BodyModel.class);

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Errorrr...", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> map = new HashMap<String, String>();

                // pass your input text

                map.put("date", date.getText().toString());
                map.put("time", time.getText().toString());

                map.put("name", name.getText().toString());
                map.put("unit", unit.getText().toString());
                map.put("price", price.getText().toString());
                map.put("quantity", qty.getText().toString());
                map.put("total", total.getText().toString());
                map.put("typeOfTransaction", "sell");

                Log.e("para", map + "");
                return map;
            }

        };
        requestQueue.add(stringRequest);

    }
}
