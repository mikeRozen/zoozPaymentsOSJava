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
import com.dogiz.zoozpaymentsos.control.JsonParser;
import com.dogiz.zoozpaymentsos.requests.OpenPaymentRequest;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;


/**
 *
 * @author Michael
 */
public class Controller {
     //private final CloseableHttpClient httpClient;
     //ControllerSiteConfiguration config;
     private final ZoozServer zoozServer;
     
    
     public Controller(ControllerSiteConfiguration config) {
//        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
//        connManager.setMaxTotal(200);
//        this.httpClient = HttpClients.custom().setConnectionManager(connManager).build();
//        this.config = config;
          this.zoozServer = new ZoozServer(config);
    }

    public Controller(HttpClientConnectionManager connectionManager,ControllerSiteConfiguration config) {
        //this.httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
        //this.config = config;
        this.zoozServer = new ZoozServer(connectionManager, config);
    }
    
    
    public Customer customerByReference(String refernce) {
        String returnStr = null;
        try {
            String uriStr = CommonParameters.ZOOZ_BASE_URL + "customers?customer_reference=" + refernce;
            HttpGet httpGet = (HttpGet) httpBuidMethod("GET", uriStr, null);
            returnStr = sendRequest(httpGet);
        } catch (Exception e) {
            System.out.println("customerByReference Error: " + e.getMessage());
            return null;
        }

        List<Customer> customersList = JsonParser.fromJsonArray(returnStr, Customer[].class);
        Customer customer = customersList.get(0);
        return customer;
    }
    
    public Payment paymentCreate(int amount, String currency){
        String returnStr = null;
        try {
            String uriStr = CommonParameters.ZOOZ_BASE_URL + "payments";
            JsonObject body = new JsonObject();
            body.addProperty("amount", UnitsConverter.minorUnitConveert(amount, currency));
            body.addProperty("currency", currency);
            HttpPost httpPost = (HttpPost) httpBuidMethod("POST", uriStr, body.toString());
            
            returnStr = sendRequest(httpPost);
        } catch (Exception e) {
            System.out.println("paymentCreate Error: " + e.getMessage());
            return null;
        }

        Payment payment = JsonParser.fromJson(returnStr, Payment.class);
        return payment;
    }
    
    public Charge chargeApply(String paymentId,PaymentMethod paymentMethod){
        String returnStr = null;
        try {
            String uriStr = CommonParameters.ZOOZ_BASE_URL + "payments/" + paymentId + "/charges";
            String jsonStr = JsonParser.toJsonRoot(paymentMethod);
            HttpPost httpPost = (HttpPost)httpBuidMethod("POST", uriStr, jsonStr);
            returnStr = sendRequest(httpPost);
        } catch (Exception e) {
            System.out.println("chargeApply Error: " + e.getMessage());
            return null;
        }

        Charge charge = JsonParser.fromJson(returnStr, Charge.class);
        return charge;
    }
    
    public PaymentMethod createToken(PaymentMethod paymentMethod){
           String returnStr = null;
        try {
            String uriStr = CommonParameters.ZOOZ_BASE_URL + "tokens";
            String jsonStr = JsonParser.toJsonRoot(paymentMethod);
            HttpPost httpPost = (HttpPost)httpBuidMethod("POST", uriStr, jsonStr);
            returnStr = sendRequest(httpPost);
        } catch (Exception e) {
            System.out.println("create Token Error: " + e.getMessage());
            return null;
        }

        PaymentMethod paymentMethodResult = JsonParser.fromJson(returnStr, PaymentMethod.class);
        return paymentMethodResult;
        
    }
    
    
    
}
