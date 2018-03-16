package com.example.caiwb.weathertest.util;

import com.example.caiwb.weathertest.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by caiwb on 2018/3/15.
 */

public class Utils {

    public static String getWeek(String date){
        String week = "星期";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(c.get(Calendar.DAY_OF_WEEK) == 1)
            week += "天";
        if(c.get(Calendar.DAY_OF_WEEK) == 2)
            week += "一";
        if(c.get(Calendar.DAY_OF_WEEK) == 3)
            week += "二";
        if(c.get(Calendar.DAY_OF_WEEK) == 4)
            week += "三";
        if(c.get(Calendar.DAY_OF_WEEK) == 5)
            week += "四";
        if(c.get(Calendar.DAY_OF_WEEK) == 6)
            week += "五";
        if(c.get(Calendar.DAY_OF_WEEK) == 7)
            week += "六";
        return week;
    }

    public static int getWeatherImg(String wInfo) {
        switch (wInfo) {
            case "晴" :
                return R.drawable.a100;
            case "多云" :
                return R.drawable.a101;
            case "少云" :
                return R.drawable.a102;
            case "晴间多云" :
                return R.drawable.a103;
            case "阴" :
                return R.drawable.a104;
            case "有风" :
                return R.drawable.a200;
            case "平静" :
                return R.drawable.a201;
            case "微风" :
                return R.drawable.a101;
            case "和风" :
                return R.drawable.a203;
            case "清风" :
                return R.drawable.a204;
            case "强风/劲风" :
                return R.drawable.a205;
            case "疾风" :
                return R.drawable.a206;
            case "大风" :
                return R.drawable.a207;
            case "烈风" :
                return R.drawable.a208;
            case "风暴" :
                return R.drawable.a209;
            case "狂爆风" :
                return R.drawable.a210;
            case "飓风" :
                return R.drawable.a211;
            case "龙卷风" :
                return R.drawable.a212;
            case "热带风暴" :
                return R.drawable.a213;
            case "阵雨" :
                return R.drawable.a300;
            case "强阵雨" :
                return R.drawable.a301;
            case "雷阵雨" :
                return R.drawable.a302;
            case "强雷阵雨" :
                return R.drawable.a303;
            case "雷阵雨伴有冰雹" :
                return R.drawable.a304;
            case "小雨" :
                return R.drawable.a305;
            case "中雨" :
                return R.drawable.a306;
            case "大雨" :
                return R.drawable.a307;
            case "极端降雨" :
                return R.drawable.a312;
            case "毛毛雨/细雨" :
                return R.drawable.a309;
            case "暴雨" :
                return R.drawable.a310;
            case "大暴雨" :
                return R.drawable.a311;
            case "特大暴雨" :
                return R.drawable.a312;
            case "冻雨" :
                return R.drawable.a313;
            case "小雪" :
                return R.drawable.a400;
            case "中雪" :
                return R.drawable.a401;
            case "大雪" :
                return R.drawable.a402;
            case "暴雪" :
                return R.drawable.a403;
            case "雨夹雪" :
                return R.drawable.a404;
            case "雨雪天气" :
                return R.drawable.a405;
            case "阵雨夹雪" :
                return R.drawable.a406;
            case "阵雪" :
                return R.drawable.a407;
            case "薄雾" :
                return R.drawable.a500;
            case "雾" :
                return R.drawable.a501;
            case "霾" :
                return R.drawable.a502;
            case "扬沙" :
                return R.drawable.a503;
            case "浮尘" :
                return R.drawable.a504;
            case "沙尘暴" :
                return R.drawable.a507;
            case "强沙尘暴" :
                return R.drawable.a508;
            case "热" :
                return R.drawable.a900;
            case "冷" :
                return R.drawable.a901;
            case "未知" :
                return R.drawable.a999;
        }
        return R.drawable.a999;
    }
}
