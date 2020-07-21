package com.iotsoftbd.apptransaction.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TransactionInfo implements Serializable {

    public List<Transaction> transaction;
    private String payg_device_number;
    private String amount;
    private String message;

    public TransactionInfo() {
    }

    public TransactionInfo(List<Transaction> transaction, String payg_device_number, String amount, String message) {
        this.transaction = transaction;
        this.payg_device_number = payg_device_number;
        this.amount = amount;
        this.message = message;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    public String getPayg_device_number() {
        return payg_device_number;
    }

    public void setPayg_device_number(String payg_device_number) {
        this.payg_device_number = payg_device_number;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public class Transaction {

        @SerializedName("transactions")
        @Expose(serialize = false)
        private String id;

        private String transaction_amount;

        private String transaction_token;


        private String installment_amount;

        private String transaction_datetime;

        private List<String> installment_count;

        public Transaction() {
        }

        public Transaction(String id, String transaction_amount, String transaction_token, String installment_amount, String transaction_datetime, List<String> installment_count) {
            this.id = id;
            this.transaction_amount = transaction_amount;
            this.transaction_token = transaction_token;
            this.installment_amount = installment_amount;
            this.transaction_datetime = transaction_datetime;
            this.installment_count = installment_count;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTransaction_amount() {
            return transaction_amount;
        }

        public void setTransaction_amount(String transaction_amount) {
            this.transaction_amount = transaction_amount;
        }

        public String getTransaction_token() {
            return transaction_token;
        }

        public void setTransaction_token(String transaction_token) {
            this.transaction_token = transaction_token;
        }

        public String getInstallment_amount() {
            return installment_amount;
        }

        public void setInstallment_amount(String installment_amount) {
            this.installment_amount = installment_amount;
        }

        public String getTransaction_datetime() {
            return transaction_datetime;
        }

        public void setTransaction_datetime(String transaction_datetime) {
            this.transaction_datetime = transaction_datetime;
        }

        public List<String> getInstallment_count() {
            return installment_count;
        }

        public void setInstallment_count(List<String> installment_count) {
            this.installment_count = installment_count;
        }
    }
}
