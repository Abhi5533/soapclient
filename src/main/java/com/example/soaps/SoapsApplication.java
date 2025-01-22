package com.example.soaps;

import com.example.generated.*;
import com.example.soaps.service.AddRequest;
import com.example.soaps.service.AddRes;
import com.example.soaps.service.SoapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import org.tempuri.Add;
//import org.tempuri.AddResponse;
//import org.tempuri.ObjectFactory;

@SpringBootApplication
@RestController
public class SoapsApplication {

		@Autowired
	private SoapClient soapClient;
//
	@PostMapping("/add")
	public AddRes add(@RequestBody AddRequest request) {
		ObjectFactory objectFactory= new ObjectFactory();
		Add addreq=objectFactory.createAdd();
		addreq.setIntA(request.getA());
		addreq.setIntB(request.getB());
		AddRes res=new AddRes();
		res.setResult( soapClient.callWebService("http://www.dneonline.com/calculator.asmx",addreq,AddResponse.class).getAddResult());

//		res.setResult( soapClient.addNumbers(addreq).getAddResult());
		return res;
	}

	@PostMapping("/substract")
	public AddRes substract(@RequestBody AddRequest request) {
		ObjectFactory objectFactory= new ObjectFactory();
		Subtract addreq=objectFactory.createSubtract();
		addreq.setIntA(request.getA());
		addreq.setIntB(request.getB());
		AddRes res=new AddRes();
		res.setResult( soapClient.callWebService("http://www.dneonline.com/calculator.asmx",addreq,SubtractResponse.class).getSubtractResult());

//		res.setResult( soapClient.addNumbers(addreq).getSubtractResult());
		return res;
	}

	@PostMapping("/multiply")
	public AddRes multiply(@RequestBody AddRequest request) {
		ObjectFactory objectFactory= new ObjectFactory();
		Multiply addreq=objectFactory.createMultiply();
		addreq.setIntA(request.getA());
		addreq.setIntB(request.getB());
		AddRes res=new AddRes();
		res.setResult( soapClient.callWebService("http://www.dneonline.com/calculator.asmx",addreq,MultiplyResponse.class).getMultiplyResult());
		return res;
	}

	@PostMapping("/divide")
	public AddRes divide(@RequestBody AddRequest request) {
		ObjectFactory objectFactory= new ObjectFactory();
		Divide addreq=objectFactory.createDivide();
		addreq.setIntA(request.getA());
		addreq.setIntB(request.getB());
		AddRes res=new AddRes();
		res.setResult( soapClient.callWebService("http://www.dneonline.com/calculator.asmx",addreq,DivideResponse.class).getDivideResult());
		return res;
	}

	public static void main(String[] args) {
		SpringApplication.run(SoapsApplication.class, args);
	}

}
