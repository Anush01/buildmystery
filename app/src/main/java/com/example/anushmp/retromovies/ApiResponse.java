package com.example.anushmp.retromovies;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ApiResponse {

    @SerializedName("coming_soon")
    @Expose
    private List<ComingSoon> comingSoon = null;
    @SerializedName("now_showing")
    @Expose
    private List<NowShowing> nowShowing = null;

    public List<ComingSoon> getComingSoon() {
        return comingSoon;
    }

    public void setComingSoon(List<ComingSoon> comingSoon) {
        this.comingSoon = comingSoon;
    }

    public List<NowShowing> getNowShowing() {
        return nowShowing;
    }

    public void setNowShowing(List<NowShowing> nowShowing) {
        this.nowShowing = nowShowing;
    }

}
