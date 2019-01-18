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
package com.dogiz.zoozpaymentsos.control;

import com.dogiz.zoozpaymentsos.beans.Charge;
import com.dogiz.zoozpaymentsos.beans.Customer;
import com.dogiz.zoozpaymentsos.beans.Payment;
import com.dogiz.zoozpaymentsos.beans.PaymentMethod;
import com.dogiz.zoozpaymentsos.beans.Authorize;
import com.dogiz.zoozpaymentsos.beans.AuthorizeResponse;
import com.dogiz.zoozpaymentsos.beans.VoidResponse;
import java.util.Map;
import org.apache.http.conn.HttpClientConnectionManager;


/**
 *
 * @author Michael
 */
public class ZoozController {
     private final ZoozServer zoozServer;
     
    
     public ZoozController(ControllerSiteConfiguration config) {
          this.zoozServer = new ZoozServer(config);
    }

    public ZoozController(HttpClientConnectionManager connectionManager,ControllerSiteConfiguration config) {
        this.zoozServer = new ZoozServer(connectionManager, config);
    }
    
    
    public Customer customerByReference(String refernce) throws Exception {
        String uriStr = ZoozCommonParameters.ZOOZ_BASE_URL + "customers?customer_reference=" + refernce;
        Customer customer = zoozServer.customerByReference(uriStr);
        return customer;
    }
    
    public Customer customerCreate(Customer customer) throws Exception{
        String uriStr = ZoozCommonParameters.ZOOZ_BASE_URL + "customers";
        Customer zoozCustomer = zoozServer.customerCreate(uriStr, customer);
        return zoozCustomer;
    }
    
    public Payment paymentCreate(Payment payment) throws Exception{
        String returnStr = null;
        String uriStr = ZoozCommonParameters.ZOOZ_BASE_URL + "payments";
        Payment zoozPayment = zoozServer.paymentCreate(uriStr, payment);
        return zoozPayment;
    }
    
    public Charge chargeApply(String paymentId,PaymentMethod paymentMethod) throws Exception {
        String uriStr = ZoozCommonParameters.ZOOZ_BASE_URL + "payments/" + paymentId + "/charges";
        Charge charge = zoozServer.chargeApply(uriStr, paymentId, paymentMethod);
        return charge;
    }
    
    public PaymentMethod createToken(PaymentMethod paymentMethod) throws Exception{
        String uriStr = ZoozCommonParameters.ZOOZ_BASE_URL + "tokens";
        PaymentMethod paymentMethodResult = zoozServer.createToken(uriStr, paymentMethod);
        return paymentMethodResult;
    }
    
    public AuthorizeResponse autorizePayment(String paymentId, Authorize authorization) throws Exception{
         String uriStr = ZoozCommonParameters.ZOOZ_BASE_URL + "payments/" + paymentId + "/authorizations";
         AuthorizeResponse authorizeResponse =  zoozServer.autorizePayment(uriStr, authorization);
         return authorizeResponse;
    }
    
    public VoidResponse dismissAuthorization(String paymentId,Map additionalDetails)throws Exception{
         String uriStr = ZoozCommonParameters.ZOOZ_BASE_URL + "payments/" + paymentId + "/voids";
         VoidResponse zoozVoidResponse  = zoozServer.dismissAuthorization(uriStr, additionalDetails);
         return zoozVoidResponse;
    }
    
    public PaymentMethod storeToken(String token,Customer customer) throws Exception{
        String uriStr = ZoozCommonParameters.ZOOZ_BASE_URL + "customers/"+customer.getId()+"/payment-methods/"+ token;
        PaymentMethod paymentMethodResult = zoozServer.storeToken(uriStr, token, customer);
        return paymentMethodResult;
    }
    
    
}
