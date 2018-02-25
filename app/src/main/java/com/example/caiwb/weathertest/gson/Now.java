package com.example.caiwb.weathertest.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by caiwb on 2018/2/25.
 */

public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More {

        @SerializedName("txt")
        public String info;
    }
}
