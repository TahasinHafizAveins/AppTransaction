package com.iotsoftbd.apptransaction.JsonApi;


import android.util.Log;

import com.iotsoftbd.apptransaction.models.TransactionInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonApi {
    @GET("get_transaction_information/")
    Call<TransactionInfo> getAllTransaction();

}

