package com.rga.swagger.swaggerexample.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@ApiModel("Custom base response object")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RGABaseResponse {

    @ApiModelProperty(notes = "The message property", dataType = "String", example = "Bad Request")
    private String message;

    @ApiModelProperty(notes = "The status property", dataType = "String", required = true, example = "Bad Request")
    private String status;

    @ApiModelProperty(notes = "The HTTP response code", dataType = "int", required = true, example = "400")
    private int responseCode;

    @ApiModelProperty(notes = "List of fields with validation error",
            dataType = "[Ljava.lang.String;", required = true,
            example = "[ \"Invalid input has been submitted for: id\" ]")
    private List<String> validationErrorList;

    /*public RGABaseResponse(String message, String status, int responseCode) {
        this.message = message;
        this.status = status;
        this.responseCode = responseCode;
    }*/

    public RGABaseResponse(String message, String status, int responseCode, List<String> validationErrorList) {
        this.message = message;
        this.status = status;
        this.responseCode = responseCode;
        this.validationErrorList = validationErrorList;
    }
}
