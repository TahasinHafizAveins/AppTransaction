package com.iotsoftbd.apptransaction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.iotsoftbd.apptransaction.models.TransactionInfo;

import java.util.List;

public class TransactionListActivity extends AppCompatActivity {

    TransactionInfo transactionInfo;
    RecyclerView trasactionList;
    TransactionAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_list);

        this.transactionInfo = (TransactionInfo) getIntent().getSerializableExtra("TRANSACTION");

        trasactionList = findViewById(R.id.transactionListView);
        adapter = new TransactionAdapter(this,transactionInfo.getTransaction(),trasactionList);

        LinearLayoutManager linearLayoutManager_vertical = new LinearLayoutManager(this);
        linearLayoutManager_vertical.setOrientation(LinearLayoutManager.VERTICAL);
        trasactionList.setLayoutManager(linearLayoutManager_vertical);
        trasactionList.setAdapter(adapter);
        renderTransaction(transactionInfo.transaction);






    }

    private void renderTransaction(List<TransactionInfo.Transaction> transaction) {
        for (TransactionInfo.Transaction transactions : transaction){
            adapter.addTransactionInfo(transactions);
        }
    }
}
