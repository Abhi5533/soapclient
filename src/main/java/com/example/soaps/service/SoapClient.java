package com.example.soaps.service;

//import com.example.Soap.api.model.Add;
//import com.example.Soap.api.model.AddResponse;
import com.example.generated.Add;
import com.example.generated.AddResponse;
import com.example.generated.Subtract;
import com.example.generated.SubtractResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
//import org.tempuri.Add;
//import org.tempuri.AddResponse;

@Service
public class SoapClient {

    @Autowired
    private Jaxb2Marshaller marshaller;
//    @Autowired
    private WebServiceTemplate template;
    @Autowired
    private SaajSoapMessageFactory messageFactory;
//    if (marshaller == null) {
//            throw new IllegalArgumentException("marshaller must not be null");
//        }
//    else{
//        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller);
//    }

    public void performWebServiceCall() {
        if (marshaller == null) {
            throw new IllegalArgumentException("marshaller must not be null");
        } else {
             template = new WebServiceTemplate(marshaller);
            template.setMessageFactory(messageFactory);
            // Use webServiceTemplate for SOAP calls
        }
    }



//// Set the SOAPAction for the request
//webServiceTemplate.setDefaultUri("http://example.com/soap"); // your service URI
//webServiceTemplate.afterPropertiesSet();
//
//    SoapActionCallback callback = new SoapActionCallback("http://tempuri.org/Add");
//
//    Add addRequest = new Add();
//addRequest.setIntA(5);
//addRequest.setIntB(10);

    // Call the web service
//    AddResponse response = (AddResponse) webServiceTemplate.marshalSendAndReceive(addRequest, callback);


    public AddResponse addNumbers(Add request){
        performWebServiceCall();
         AddResponse res = (AddResponse) template.marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",
                request);
         return res;
    }

    public SubtractResponse addNumbers(Subtract request){
        performWebServiceCall();
        SubtractResponse res = (SubtractResponse) template.marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",
                request);
        return res;
    }

    public <T, R> R callWebService(String url, T request, Class<R> responseType) {
        performWebServiceCall();
        return (R) template.marshalSendAndReceive(url, request);
    }


}
