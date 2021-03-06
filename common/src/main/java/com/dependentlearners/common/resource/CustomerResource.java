package com.dependentlearners.common.resource;

import com.dependentlearners.common.representation.Customer;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "customer")
public interface CustomerResource {

    @RequestMapping(value = "/customers/{id}",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") long id);

    @RequestMapping(value = "/customers",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    ResponseEntity<List<Customer>> getCustomers();

}
