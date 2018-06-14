package com.hotwaxsystems.www.wscautomation.datalayer.remote.pojo.utilities;

/**
 * Created by darkshadow on 25/3/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginPojo {

    @SerializedName("removePathAlias")
    @Expose
    private Boolean removePathAlias;
    @SerializedName("sessionId")
    @Expose
    private String sessionId;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("webSiteId")
    @Expose
    private String webSiteId;

    public Boolean getRemovePathAlias() {
        return removePathAlias;
    }

    public void setRemovePathAlias(Boolean removePathAlias) {
        this.removePathAlias = removePathAlias;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getWebSiteId() {
        return webSiteId;
    }

    public void setWebSiteId(String webSiteId) {
        this.webSiteId = webSiteId;
    }

}
