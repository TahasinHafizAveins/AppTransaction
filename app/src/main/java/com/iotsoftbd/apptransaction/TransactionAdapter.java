package com.iotsoftbd.apptransaction;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;


import com.iotsoftbd.apptransaction.models.TransactionInfo;

import java.util.ArrayList;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionAdapterHolder> {

    private TransactionListActivity transactionListActivity;
    private LayoutInflater inflater;
    private List<TransactionInfo.Transaction > transactionList;
    private RecyclerView mRecyclerView;

    public TransactionAdapter(TransactionListActivity transactionListActivity, List<TransactionInfo.Transaction> transactionList, RecyclerView mRecyclerView) {
        this.transactionListActivity = transactionListActivity;
        this.inflater = LayoutInflater.from(transactionListActivity);
        this.transactionList = transactionList;
        this.mRecyclerView = mRecyclerView;
    }

    @NonNull
    @Override
    public TransactionAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.app_payment_loan_complete,parent,false);
        return new TransactionAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapterHolder holder, int position) {

        TransactionInfo.Transaction  transaction = transactionList.get(position);
        holder.bind(transaction);

    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    public void addTransactionInfo (TransactionInfo.Transaction  transaction){
        transactionList.add(transaction);
        int position = transactionList.indexOf(transaction);
        notifyItemInserted(position);

    }

    public void removeTransactionInfo (TransactionInfo.Transaction  transaction){
        int position = getPosition(transaction);
        if (position != -1){
            transactionList.remove(position);
            notifyItemRemoved(position);
        }

    }

    public TransactionInfo.Transaction  getTransactionInfo (int position){
        return this.transactionList.get(position);
    }

    public void restoreTransactionInfo(TransactionInfo.Transaction  transaction){
        transactionList.add(transaction);
        int position = transactionList.indexOf(transaction);
        notifyItemInserted(position);
    }

    private int getPosition(TransactionInfo.Transaction  transaction){
        for (TransactionInfo.Transaction  x:transactionList){
            if (x.getId().equals(transaction.getId())){
                return transactionList.indexOf(x);
            }
        }
        return -1;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }



    public static class TransactionAdapterHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView transaction_amount,transaction_token,installment_amount ,transaction_datetime;

        TransactionAdapterHolder(@NonNull View itemView) {
            super(itemView);

            transaction_amount= itemView.findViewById(R.id.tv_transaction_amount);
            transaction_token = itemView.findViewById(R.id.tv_transaction_token);
            installment_amount = itemView.findViewById(R.id.tv_instalmentAmount);
            transaction_datetime = itemView.findViewById(R.id.tv_tDatetime);


            itemView.setOnClickListener(this);
        }
        void bind(TransactionInfo.Transaction  transaction){
            transaction_amount.setText(transaction.getTransaction_amount());
            transaction_token.setText(transaction.getTransaction_token());
            installment_amount.setText(transaction.getInstallment_amount());
            transaction_datetime.setText(transaction.getTransaction_datetime());
        }

        @Override
        public void onClick(View view) {

        }


    }
}