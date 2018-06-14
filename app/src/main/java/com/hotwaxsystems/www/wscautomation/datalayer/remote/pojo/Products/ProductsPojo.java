package com.hotwaxsystems.www.wscautomation.datalayer.remote.pojo.Products;

/**
 * Created by darkshadow on 26/3/18.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductsPojo {

    @SerializedName("result")
    @Expose
    private List<Result> result = null;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

}
