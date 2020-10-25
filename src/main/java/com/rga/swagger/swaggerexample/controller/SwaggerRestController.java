package com.rga.swagger.swaggerexample.controller;

import com.rga.swagger.swaggerexample.model.Attributes;
import com.rga.swagger.swaggerexample.model.DataResponse;
import com.rga.swagger.swaggerexample.model.RGABaseResponse;
import com.rga.swagger.swaggerexample.model.Response;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Api(value = "Spring Boot Swagger example")
@RequiredArgsConstructor
@RestController
@RequestMapping("/swagger")
public class SwaggerRestController {

    @ApiOperation(value = "This is a test endpoint",response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/greeting/{fname}")
    String greet(@ApiParam(value = "Symbol", allowableValues = "any string", required = true) @PathVariable(name = "fname") String fname) {
        return "Hi " + fname + ", Welcome to Swagger project!";
    }

    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Response> getResponse(@ApiParam(name = "id", value = "The sample id", required = true)
                                                    @PathVariable(name = "id") String id) {
        Response response = new Response();
        response.setMessage("Hi");
        response.setSuccess(Boolean.TRUE);
        response.setId(id);
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }

    @ApiOperation(value = "This is a test endpoint", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved data", response = DataResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = RGABaseResponse.class)
    }
    )
    @PostMapping("/greeting/{fname}")
    ResponseEntity<DataResponse> getUserData(@RequestBody Attributes attributes) {
        DataResponse dataResponse = new DataResponse();
        List list = new ArrayList();
        list.add(attributes);
        dataResponse.setRecords(list);
        return new ResponseEntity<>(dataResponse, new HttpHeaders(), HttpStatus.OK);
    }

}
