package vamsee.application.digitalregisterassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import vamsee.application.digitalregisterassignment.Model.BodyModel;
import vamsee.application.digitalregisterassignment.Model.Transaction;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Transaction> mDataArray = new ArrayList<>();
    private TransactionListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.txnHistory);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
    }


    void loadData() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://178e-2405-201-3017-105f-d94b-13a-861e-2a74.ngrok.io/api/getTransactionList";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0; i<response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Transaction transaction = new Transaction(
                                        jsonObject.getString("date"),
                                        jsonObject.getString("time"),
                                        jsonObject.getString("name"),
                                        jsonObject.getString("unit"),
                                        jsonObject.getInt("quantity"),
                                        jsonObject.getInt("totalPrice"),
                                        jsonObject.getString("typeOfTransaction")
                                        );
                                mDataArray.add(transaction);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        mAdapter = new TransactionListAdapter(mDataArray);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "API error..", Toast.LENGTH_LONG).show();
                    }
                });

        queue.add(jsonArrayRequest);
    }

    public void sell(View view) {
        Intent intent = new Intent(this, SellActivity.class);
        startActivity(intent);

    }
}