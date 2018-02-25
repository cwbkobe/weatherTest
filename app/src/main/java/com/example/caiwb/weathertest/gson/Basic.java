package com.example.caiwb.weathertest.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by caiwb on 2018/2/25.
 */

public class Basic {

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update {

        @SerializedName("loc")
        public String updateTime;
    }
}
