package com.bytecodedevelocity.config;

import com.bytecodedevelocity.hrms.GetEmployeeRequest;
import com.bytecodedevelocity.hrms.GetEmployeeResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class endPointConfiguration {

    @PayloadRoot(namespace = "http://bytecodedevelocity.com/hrms", localPart = "GetEmployeeRequest")
    @ResponsePayload
    public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request){
        GetEmployeeResponse response = new GetEmployeeResponse();
        response.setEmployeeId(request.getEmployeeId());
        response.setEmployeeName("Nancy Momoland");
        response.setLocation("Jaksel");
        response.setZipcode(12345);
        return  response;
    }
}
