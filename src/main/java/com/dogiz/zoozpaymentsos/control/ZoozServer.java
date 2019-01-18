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

package com.dogiz.zoozpaymentsos.control;

import com.dogiz.zoozpaymentsos.beans.Charge;
import com.dogiz.zoozpaymentsos.beans.Customer;
import com.dogiz.zoozpaymentsos.beans.Payment;
import com.dogiz.zoozpaymentsos.beans.PaymentMethod;
import com.dogiz.zoozpaymentsos.beans.Authorize;
import com.dogiz.zoozpaymentsos.beans.AuthorizeResponse;
import com.dogiz.zoozpaymentsos.beans.VoidResponse;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Michael
 */


public class ZoozServer {
     private final CloseableHttpClient httpClient;
     ControllerSiteConfiguration config;
     
      public ZoozServer(ControllerSiteConfiguration config) {
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(200);
        this.httpClient = HttpClients.custom().setConnectionManager(connManager).build();
        this.config = config;
    }
      
     public Customer customerByReference(String uriStr) throws Exception{
        String returnStr = null;
        try {
            HttpGet httpGet = (HttpGet) httpBuidMethod("GET", uriStr, null);
            returnStr = sendRequest(httpGet);
        } catch (Exception e) {
            System.out.println("ZoozServer customerByReference Error: " + e.getMessage());
            throw e;
        }

        List<Customer> customersList = JsonParser.fromJsonArray(returnStr, Customer[].class);
        Customer customer = customersList.get(0);
        return customer;
    }
     
    public Customer customerCreate(String uriStr,Customer customer)throws Exception{
        String returnStr = null;
        try {
            String jsonStr = JsonParser.toJson(customer);
            HttpPost httpPost = (HttpPost)httpBuidMethod("POST", uriStr, jsonStr);
            returnStr = sendRequest(httpPost);
        } catch (Exception e) {
            System.out.println("ZoozServer customerCreate Error: " + e.getMessage());
            throw e;
        }
        
        Customer zoozCustomer = JsonParser.fromJson(returnStr, Customer.class);
        return zoozCustomer;
        
    } 
    
    public Payment paymentCreate(String uriStr,Payment payment) throws Exception{
        String returnStr = null;
        try {
            int amount = UnitsConverter.minorUnitConveert(payment.getAmount(), payment.getCurrency());
            payment.setAmount(amount);
            String jsonStr = JsonParser.toJson(payment);
            HttpPost httpPost = (HttpPost) httpBuidMethod("POST", uriStr, jsonStr);
            
            returnStr = sendRequest(httpPost);
        } catch (Exception e) {
            System.out.println("ZoozServer paymentCreate Error: " + e.getMessage());
            throw e;
        }

        Payment paymentZooz = JsonParser.fromJson(returnStr, Payment.class);
        return paymentZooz;
    }
    
    public Charge chargeApply(String uriStr,String paymentId,PaymentMethod paymentMethod) throws Exception{
        String returnStr = null;
        try {
            String jsonStr = JsonParser.toJsonRoot(paymentMethod);
            HttpPost httpPost = (HttpPost)httpBuidMethod("POST", uriStr, jsonStr);
            returnStr = sendRequest(httpPost);
        } catch (Exception e) {
            System.out.println("ZoozServer chargeApply Error: " + e.getMessage());
            throw e;
        }

        Charge charge = JsonParser.fromJson(returnStr, Charge.class);
        return charge;
    }
    
    public PaymentMethod createToken(String uriStr,PaymentMethod paymentMethod) throws Exception{
        String returnStr = null;
        try {
            String jsonStr = JsonParser.toJson(paymentMethod);
            HttpPost httpPost = (HttpPost)httpBuidMethod("POST", uriStr, jsonStr);
            returnStr = sendRequest(httpPost);
        } catch (Exception e) {
            System.out.println("ZoozServer create Token Error: " + e.getMessage());
            throw e;
        }

        PaymentMethod paymentMethodResult = JsonParser.fromJson(returnStr, PaymentMethod.class);
        return paymentMethodResult;
        
    }  
    
    public PaymentMethod storeToken(String uriStr,String token,Customer customer)throws Exception{
        String returnStr = null;
        try {
            HttpPost httpPost = (HttpPost)httpBuidMethod("POST", uriStr,null);
            returnStr = sendRequest(httpPost);
        } catch (Exception e) {
            System.out.println("ZoozServer storeToken Error: " + e.getMessage());
            throw e;
        }
        PaymentMethod paymentMethod = JsonParser.fromJson(returnStr, PaymentMethod.class);
        return paymentMethod;
    }
    
    public AuthorizeResponse autorizePayment(String uriStr, Authorize authorization) throws Exception{
        String returnStr = null;
        try {
            String jsonStr = JsonParser.toJson(authorization);
            HttpPost httpPost = (HttpPost)httpBuidMethod("POST", uriStr, jsonStr);
            returnStr = sendRequest(httpPost);
        } catch (Exception e) {
            System.out.println("ZoozServer autorizePayment Error: " + e.getMessage());
            throw e;
        }

        AuthorizeResponse authorizeResult = JsonParser.fromJson(returnStr, AuthorizeResponse.class);
        return authorizeResult;
    }
    
    public VoidResponse dismissAuthorization(String uriStr,Map additionalDetais)throws Exception{
        String returnStr = null;
        try {
            String jsonStr = JsonParser.toJson(additionalDetais);
            HttpPost httpPost = (HttpPost)httpBuidMethod("POST", uriStr, jsonStr);
            returnStr = sendRequest(httpPost);
        } catch (Exception e) {
            System.out.println("dismissAuthorization Error: " + e.getMessage());
            throw e;
        }

        VoidResponse zoozVoidResponse  = JsonParser.fromJson(returnStr, VoidResponse.class);
        return zoozVoidResponse;
    }
      
      

    public ZoozServer(HttpClientConnectionManager connectionManager,ControllerSiteConfiguration config) {
        this.httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
        this.config = config;
     
    }
    
    private HttpRequestBase httpBuidMethod(String method,String uriStr,String body) throws Exception{
        HttpRequestBase httpMethod = null;
        switch (method){
            case "POST":
                httpMethod = new HttpPost(uriStr);
                break;
            case "GET":
                httpMethod = new HttpGet(uriStr);
                break;
            case "PUT":
                break;
            default:
                break;
        }
        
        if (httpMethod != null){
            configHttp(httpMethod);
        }
        
        if (body != null){
            httpBody((HttpPost)httpMethod, body);
        }
        
        return httpMethod;
    }
      
    private void configHttp(HttpRequestBase httpMethod) throws Exception {
        httpMethod.setHeader("api-version", "1.2.0");
        httpMethod.setHeader("x-payments-os-env", config.getEnviroment());
        httpMethod.setHeader("app_id", config.getAppId());
        httpMethod.setHeader("private_key", config.getPrivateKey());
        httpMethod.setHeader("public_key", config.getPublicKey());
        httpMethod.setHeader("Content-type", "application/json; charset=utf-8");
        httpMethod.setConfig(config.getRequestConfig());
    }
    
    private void httpBody(HttpPost httpPost, String jsonStr) throws Exception{
         if (jsonStr == null){return;}
         StringEntity body = new StringEntity(jsonStr);
         httpPost.setEntity(body);
    }
    
    private String sendRequest(HttpRequestBase httpMethod) throws Exception {
        String response = null;
        HttpResponse httpRes = httpClient.execute(httpMethod);
        response = EntityUtils.toString(httpRes.getEntity());
            
        httpMethod.releaseConnection();
        int responseCode = httpRes.getStatusLine().getStatusCode();
        if (responseCode >= 200 && responseCode< 300){
            return response;
        }else{
            System.out.println("Error response: " + response);
            throw new Exception(response);
        }
    }

    
    
    
}
