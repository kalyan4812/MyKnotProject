package com.saikalyandaroju.myknotproject.NetworkService;


import com.saikalyandaroju.myknotproject.Model.MyResponse;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.POST;

public interface MyApiInterface {
    @POST("testData")
    Observable<MyResponse> getResponse();

}
