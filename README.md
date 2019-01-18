# ZoozPaymentsOSJava
![Build](https://img.shields.io/badge/build-passing-brightgreen.svg)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/mikeRozen/zoozPaymentsOSJava/blob/master/LICENSE)

A simple lightweight connector to ZoozPaymentsOS API [Zooz](https://www.zooz.com). Check out the offcial Zooz API [documentation](https://developers.paymentsos.com/docs/api/) to see all possible options.

## Installation
You may use the Maven repository<br />
``` 
<dependency>
  <groupId>com.dogiz</groupId>
  <artifactId>ZoozPaymentsOS</artifactId>
  <version>1.2</version>
</dependency> 
``` 
Please check the [Dependencies](#dependencies)

## Example

```java  
ControllerSiteConfiguration configuration = new ControllerSiteConfiguration("appId", "publicKey", "privateKey",isSandbox);
controller = new Controller(configuration); 

//Create client by reference
 Customer customer = new Customer("ReferenceNumber");
 customer.setFirstName("Test1");
 customer.setEmail("test@gmail.con");
 Customer zoozCustomer = controller.customerCreate(customer);
 
 //Token creation
 PaymentMethod paymentMethod = new PaymentMethod();
 paymentMethod.setCardNumber("4580458045804580");
 paymentMethod.setCreditCardCvv("123");
 paymentMethod.setExpirationMonth("02");
 paymentMethod.setExpirationYear("21");
 paymentMethod.setHolderName("Test123");       
 PaymentMethod paymentMethodResponse = controller.createToken(paymentMethod);
 
 //Validate Card
  Payment payment = new Payment(1, "USD");
  payment.setCustomerId("Customer ID");
  payment = controller.paymentCreate(payment);
  Authorize authorization = new Authorize();
  PaymentMethod paymentMethod = new PaymentMethod();
  paymentMethod.setToken("Token");
  paymentMethod.setType("tokenized");
  authorization.setPaymentMethod(paymentMethod);
  AuthorizeResponse response = controller.autorizePayment(payment.getId(), authorization);
  VoidResponse voidResponse = controller.dismissAuthorization(payment.getId(), null); // Void the authorization (not necessary)
 
 //Charge
  Charge charge = controller.chargeApply("payment id", paymentMethod);
 
 //Associate Token to customer
  Customer customer = new Customer();
  customer.setId("customer id");
  PaymentMethod paymentMethod = controller.storeToken("token",customer);
 
 //Retrive Customer by refernce
  Customer customer = controller.customerByReference(reference);
 
``` 

## Dependencies 
- [Apache Http Components](http://hc.apache.org/index.html)
- [Google-gson](https://github.com/google/gson)
- [Hamcrest](https://github.com/hamcrest/JavaHamcrest)
- [Junit](https://junit.org/junit4/)

## Author

Michael Rozenblat

## License

ZoozPaymentsOSJava is available under the MIT license. See the [LICENSE](https://github.com/mikeRozen/zoozPaymentsOSJava/blob/master/LICENSE) file for more info.
