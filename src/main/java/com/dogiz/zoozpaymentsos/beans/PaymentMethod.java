/*
 * MIT License
 *
 * Copyright (c) 2018 mikeRozen
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.dogiz.zoozpaymentsos.beans;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 *
 * @author Michael
 * TODO: We need to think on proper way to subclass or split the class 
 * in correct respond request methods
 */
public class PaymentMethod {
    String cardNumber;
    String creditCardCvv;
    String expirationMonth;
    String expirationYear;
    String expirationDate;
    String holderName;
    @SerializedName("last_4_digits")
    String last4Digits;
    String tokenType;
    String token;
    BillingAddress billingAddress;
    IdentityDocument identityDocument;
    
    String type;
    Map threeDSecureAttributes;
    Map installments;
    String merchantSiteUrl;
    Map providerSpecificData;
    Map cofTransactionIndicators;
    Map additionalDetails;
    String href;
    String created;
    String customer;
    String fingerprint;
    Map identityDocumen;
    String countryCode;
    Boolean passLuhnValidation;
    String binNumber;
    String vendor;
    String issuer;
    String cardType;
    String level;

    public PaymentMethod() {
        this.tokenType = "credit_card";
    }
    
    public PaymentMethod(String token,String type) {
        this.token = token;
        this.type = type;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = String.format("%02d", Integer.valueOf(expirationMonth));//expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public IdentityDocument getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(IdentityDocument identityDocument) {
        this.identityDocument = identityDocument;
    }

    
    
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Map getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(Map additionalDetails) {
        this.additionalDetails = additionalDetails;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public Map getIdentityDocumen() {
        return identityDocumen;
    }

    public void setIdentityDocumen(Map identityDocumen) {
        this.identityDocumen = identityDocumen;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBilling_address(BillingAddress billing_address) {
        this.billingAddress = billing_address;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getExpirationDate() {
        return getExpirationMonth() + "/" + getExpirationYear();
    }

//    public void setExpirationDate(String expirationDate) {
//        this.expirationDate = expirationDate;
//    }

    public String getLast4Digits() {
        return last4Digits;
    }

    public void setLast4Digits(String last4Digits) {
        this.last4Digits = last4Digits;
    }

    public Boolean isPassLuhnValidation() {
        return passLuhnValidation;
    }

    public void setPassLuhnValidation(Boolean passLuhnValidation) {
        this.passLuhnValidation = passLuhnValidation;
    }

    public String getBinNumber() {
        return binNumber;
    }

    public void setBinNumber(String binNumber) {
        this.binNumber = binNumber;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCreditCardCvv() {
        return creditCardCvv;
    }

    public void setCreditCardCvv(String creditCardCvv) {
        this.creditCardCvv = creditCardCvv;
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

    public Map getCofTransactionIndicators() {
        return cofTransactionIndicators;
    }

    public void setCofTransactionIndicators(Map cofTransactionIndicators) {
        this.cofTransactionIndicators = cofTransactionIndicators;
    }
    
    
    
    
}
