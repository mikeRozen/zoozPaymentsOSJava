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

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;

/**
 *
 * @author Michael
 */
public class ControllerSiteConfiguration {
    private String appId,publicKey,privateKey;
    private RequestConfig requestConfig;
    private boolean isSandbox;
    private String enviroment;
    
    public ControllerSiteConfiguration(String appId,String publicKey,String privateKey,boolean isSandbox){
        this.appId = appId;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.requestConfig = createDefaultRequestConfig();
        this.isSandbox = isSandbox;
        this.enviroment = (isSandbox == true)? "test" : "live";
    }
    
     private RequestConfig createDefaultRequestConfig() {

        return RequestConfig.custom()
                .setSocketTimeout(ZoozCommonParameters.HTTP_TIMEOUT_CONNECTION)
                .setConnectTimeout(ZoozCommonParameters.HTTP_TIMEOUT_CONNECTION)
                .setConnectionRequestTimeout(ZoozCommonParameters.HTTP_TIMEOUT_CONNECTION)
                .build();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public RequestConfig getRequestConfig() {
        return requestConfig;
    }

    public void setRequestConfig(RequestConfig requestConfig) {
        this.requestConfig = requestConfig;
    }

    public boolean isIsSandbox() {
        return isSandbox;
    }

    public void setIsSandbox(boolean isSandbox) {
        this.isSandbox = isSandbox;
        this.enviroment = (isSandbox == true)? "test" : "live";
    }

    public String getEnviroment() {
        return enviroment;
    }
    
    
    
    public void setTimeouts(int socketTimeout, int requestTimeout, int connectionTimeout) {
        requestConfig = RequestConfig.copy(requestConfig)
                .setSocketTimeout(socketTimeout)
                .setConnectTimeout(requestTimeout)
                .setConnectionRequestTimeout(connectionTimeout)
                .build();
    }
    
}
