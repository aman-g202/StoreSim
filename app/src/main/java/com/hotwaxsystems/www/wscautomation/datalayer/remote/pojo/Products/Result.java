package com.hotwaxsystems.www.wscautomation.datalayer.remote.pojo.Products;

/**
 * Created by darkshadow on 26/3/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("requirementId")
    @Expose
    private String requirementId;
    @SerializedName("requirementTypeId")
    @Expose
    private String requirementTypeId;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("productId")
    @Expose
    private String productId;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("statusId")
    @Expose
    private String statusId;
    @SerializedName("statusDesc")
    @Expose
    private String statusDesc;
    @SerializedName("orderId")
    @Expose
    private String orderId;
    @SerializedName("poOrderId")
    @Expose
    private String poOrderId;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("estimatedAmount")
    @Expose
    private String estimatedAmount;

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public String getRequirementTypeId() {
        return requirementTypeId;
    }

    public void setRequirementTypeId(String requirementTypeId) {
        this.requirementTypeId = requirementTypeId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPoOrderId() {
        return poOrderId;
    }

    public void setPoOrderId(String poOrderId) {
        this.poOrderId = poOrderId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getEstimatedAmount() {
        return estimatedAmount;
    }

    public void setEstimatedAmount(String estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
    }

}
