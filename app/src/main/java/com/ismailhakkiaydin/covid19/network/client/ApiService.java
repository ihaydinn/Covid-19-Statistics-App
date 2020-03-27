package com.ismailhakkiaydin.covid19.network.client;

import com.ismailhakkiaydin.covid19.network.dto.CountryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface ApiService {

    @Headers("x-rapidapi-key: b952aa037bmsh7ecbf0f6bcabe58p1ff1e8jsndfddd40f88e0")
    @GET("statistics")
    Call<CountryResponse> getAllCountries();

}
