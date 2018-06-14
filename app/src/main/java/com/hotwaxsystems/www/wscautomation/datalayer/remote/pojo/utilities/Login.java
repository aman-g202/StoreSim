package com.hotwaxsystems.www.wscautomation.datalayer.remote.pojo.utilities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Login implements Serializable
{

    @SerializedName("org.apache.tomcat.util.net.secure_protocol_version")
    @Expose
    private String orgApacheTomcatUtilNetSecureProtocolVersion;
    @SerializedName("sessionId")
    @Expose
    private String sessionId;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("otherInformationObject")
    @Expose
    private Object otherInformationObject;
    private final static long serialVersionUID = 1553210794180839187L;

    public String getOrgApacheTomcatUtilNetSecureProtocolVersion() {
        return orgApacheTomcatUtilNetSecureProtocolVersion;
    }

    public void setOrgApacheTomcatUtilNetSecureProtocolVersion(String orgApacheTomcatUtilNetSecureProtocolVersion) {
        this.orgApacheTomcatUtilNetSecureProtocolVersion = orgApacheTomcatUtilNetSecureProtocolVersion;
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

    public Object getOtherInformationObject() {return otherInformationObject;}
}