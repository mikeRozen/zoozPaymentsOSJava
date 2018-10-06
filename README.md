# ZoozPaymentsOSJava
A simple connector to ZoozPaymentsOS API [Zooz](https://www.zooz.com). Check out the offcial Zooz API [documentation](https://developers.paymentsos.com/docs/api/) to see all possible options.

## Installation
There is currently NO Maven repository (Will be completed within the next few days)<br />
Currently you may use the following [JARS](https://github.com/mikeRozen/zoozPaymentsOSJava/files/2453311/ZoozPaymentsOS.zip) 
- ZoozPaymentsOS-1.0.jar (Please check the [Dependencies](#dependencies))
- ZoozPaymentsOS-1.0-jar-with-dependencies (Less recomended)

## Example

```  
ControllerSiteConfiguration configuration = new ControllerSiteConfiguration("appId", "publicKey", "privateKey",isSandbox);
controller = new Controller(configuration); 

#Extract client by reference
 String reference = "FAFADAD";
 Customer customer = controller.customerByReference(reference);

#Create payment
 Payment payment = controller.paymentCreate(5, "USD");

#Charge 
 PaymentMethod paymentMethod = new PaymentMethod(paymentToken,"tokenized");
 Charge charge = controller.chargeApply(payment.getId(),paymentMethod);
 
``` 
 

## Dependencies 
- [Apache Http Components](http://hc.apache.org/index.html)
- [Google-gson](https://github.com/google/gson)
- [Hamcrest](https://github.com/hamcrest/JavaHamcrest)
- [Junit](https://junit.org/junit4/)

## Author

Michael Rozenblat

## License

MRDropDown is available under the MIT license. See the [LICENSE](https://github.com/mikeRozen/zoozPaymentsOSJava/blob/master/LICENSE) file for more info.
