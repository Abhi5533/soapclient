package com.example.soaps;

import com.example.soaps.service.AddRequest;
import com.example.soaps.service.AddRes;
import com.example.soaps.service.SoapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tempuri.Add;
import org.tempuri.AddResponse;
import org.tempuri.ObjectFactory;

@SpringBootApplication
@RestController
public class SoapsApplication {

		@Autowired
	private SoapClient soapClient;

	@PostMapping("/add")
	public AddRes add(@RequestBody AddRequest request) {
		ObjectFactory objectFactory= new ObjectFactory();
		Add addreq=objectFactory.createAdd();
		addreq.setIntA(request.getA());
		addreq.setIntB(request.getB());
		AddRes res=new AddRes();
		res.setResult( soapClient.addNumbers(addreq).getAddResult());
		return res;
	}

	public static void main(String[] args) {
		SpringApplication.run(SoapsApplication.class, args);
	}

}
