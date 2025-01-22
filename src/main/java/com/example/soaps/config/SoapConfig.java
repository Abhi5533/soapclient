package com.example.soaps.config;

import jakarta.xml.soap.MessageFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

//import jakarta.xml.soap.MessageFactory;

@Configuration
public class SoapConfig {

//    @Bean
//    public Jaxb2Marshaller marshaller() {
//        Jaxb2Marshaller marshaller=new Jaxb2Marshaller();
//        marshaller.setPackagesToScan("com.javatechie.spring.soap.api.loaneligibility");
//        return marshaller;
//    }

//    @Bean
//    public Jaxb2Marshaller marshaller() {
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setContextPath("com.example.soap.api.model"); // Package of your JAXB-annotated classes
//        return marshaller;
//    }

//    @Bean
//    public Jaxb2Marshaller marshaller() {
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setContextPath("com.example.soaps.model");
//        return marshaller;
//    }
@Bean
public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    try {
        // Explicitly load the JAXB context
//        marshaller.setPackagesToScan("target/generated-sources/cxf/org/tempuri");

        marshaller.setClassesToBeBound(
                org.tempuri.Add.class,
                org.tempuri.AddResponse.class,
                org.tempuri.Subtract.class,
                org.tempuri.Multiply.class
        );
    } catch (Exception e) {
        throw new RuntimeException("Failed to configure JAXB marshaller", e);
    }
    return marshaller;
}
    @Bean
    public SaajSoapMessageFactory messageFactory() throws Exception {
        SaajSoapMessageFactory factory = new SaajSoapMessageFactory();
        factory.setMessageFactory(MessageFactory.newInstance());
        return factory;
    }

//
//    @Bean
//    public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller) {
//        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller);
//        webServiceTemplate.setDefaultUri("http://www.dneonline.com/calculator.asmx"); // SOAP service URL
//        return webServiceTemplate;
//    }

}
