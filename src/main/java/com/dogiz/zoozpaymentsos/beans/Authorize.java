// MIT License
//
//Copyright (c) 2018 mikeRozen
//
//Permission is hereby granted, free of charge, to any person obtaining a copy
//of this software and associated documentation files (the "Software"), to deal
//in the Software without restriction, including without limitation the rights
//to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//copies of the Software, and to permit persons to whom the Software is
//furnished to do so, subject to the following conditions:
//
//The above copyright notice and this permission notice shall be included in all
//copies or substantial portions of the Software.
//
//THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
//SOFTWARE.

package com.dogiz.zoozpaymentsos.beans;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 *
 * @author Michael
 */


public class Authorize {
    String reconciliationId;
    PaymentMethod paymentMethod;
    @SerializedName("three_d_secure_attributes")
    Map threeDSecureAttributes;
    Map installments;
    String merchantSiteUrl;
    Map providerSpecificData;
    Map additional_details;
    Map cof_transaction_indicators;

    public Authorize() {
    }

    public String getReconciliationId() {
        return reconciliationId;
    }

    public void setReconciliationId(String reconciliationId) {
        this.reconciliationId = reconciliationId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Map getThreeDSecureAttributes() {
        return threeDSecureAttributes;
    }

    public void setThreeDSecureAttributes(Map threeDSecureAttributes) {
        this.threeDSecureAttributes = threeDSecureAttributes;
    }

    public Map getInstallments() {
        return installments;
    }

    public void setInstallments(Map installments) {
        this.installments = installments;
    }

    public String getMerchantSiteUrl() {
        return merchantSiteUrl;
    }

    public void setMerchantSiteUrl(String merchantSiteUrl) {
        this.merchantSiteUrl = merchantSiteUrl;
    }

    public Map getProviderSpecificData() {
        return providerSpecificData;
    }

    public void setProviderSpecificData(Map providerSpecificData) {
        this.providerSpecificData = providerSpecificData;
    }

    public Map getAdditional_details() {
        return additional_details;
    }

    public void setAdditional_details(Map additional_details) {
        this.additional_details = additional_details;
    }

    public Map getCof_transaction_indicators() {
        return cof_transaction_indicators;
    }

    public void setCof_transaction_indicators(Map cof_transaction_indicators) {
        this.cof_transaction_indicators = cof_transaction_indicators;
    }
    
    
    
    
    
    
}
