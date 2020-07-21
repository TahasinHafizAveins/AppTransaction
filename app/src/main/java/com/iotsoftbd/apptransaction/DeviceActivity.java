package com.iotsoftbd.apptransaction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.iotsoftbd.apptransaction.JsonApi.JsonApi;
import com.iotsoftbd.apptransaction.JsonApi.ServiceGenerator;
import com.iotsoftbd.apptransaction.models.TransactionInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeviceActivity extends AppCompatActivity {

    Button btn_next;
    String deviceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);

        deviceId = "1";
        btn_next = findViewById(R.id.next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchDeviceInfo(deviceId);
            }
        });
    }

    private void fetchDeviceInfo(String deviceId) {
        JsonApi api = ServiceGenerator.createService(JsonApi.class);
        api.getAllTransaction().enqueue(new Callback<TransactionInfo>() {
            @Override
            public void onResponse(Call<TransactionInfo> call, Response<TransactionInfo> response) {
                if (response.isSuccessful()) {
                    Log.d("TransactionInfo","isSuccessful "+response.message());
                    try {
                        TransactionInfo transactionInfo = response.body();
                        Log.d("TransactionInfo"," "+transactionInfo.getAmount());
                        startActivity(transactionInfo);
                    }catch (Exception e){
                        e.printStackTrace();
                    }


                } else {
                    try {
                        if (response.errorBody() != null) {
                            String s = response.errorBody().string().replace("PAYG device is invalid. Check Details:", "");
                            Toast.makeText(getApplicationContext(), "" + s, Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<TransactionInfo> call, Throwable throwable) {
                Log.d("DeviceHistory", " " + throwable.getMessage());
            }
        });

    }

    private void startActivity(TransactionInfo transactionInfo) {
        Intent intent = new Intent(DeviceActivity.this,TransactionListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("TRANSACTION", transactionInfo);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
