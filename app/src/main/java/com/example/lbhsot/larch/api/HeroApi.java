package com.example.lbhsot.larch.api;


import com.example.lbhsot.larch.models.Heroes;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ygharsallah on 30/03/2017.
 */

public interface HeroApi {

    @GET("test-mobile/iOS/json/test2.json")
    Observable<Heroes> getHeroes();


}
