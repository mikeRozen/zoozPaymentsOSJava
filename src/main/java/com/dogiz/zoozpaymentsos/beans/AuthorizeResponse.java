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

import java.util.Map;

/**
 *
 * @author Michael
 */


public class AuthorizeResponse extends Authorize {
    String id;
    Result result;
    int amount;
    String created;
    Map providerData;
    Map redirection;
    String originatingPurchaseCountry;
    String ipAddress;
    Map decision_engineExecution;
    
    public AuthorizeResponse() {
        super(); 
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Map getProviderData() {
        return providerData;
    }

    public void setProviderData(Map providerData) {
        this.providerData = providerData;
    }

    public Map getRedirection() {
        return redirection;
    }

    public void setRedirection(Map redirection) {
        this.redirection = redirection;
    }

    public String getOriginatingPurchaseCountry() {
        return originatingPurchaseCountry;
    }

    public void setOriginatingPurchaseCountry(String originatingPurchaseCountry) {
        this.originatingPurchaseCountry = originatingPurchaseCountry;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Map getDecision_engineExecution() {
        return decision_engineExecution;
    }

    public void setDecision_engineExecution(Map decision_engineExecution) {
        this.decision_engineExecution = decision_engineExecution;
    }
    
    
    
    
    
}
