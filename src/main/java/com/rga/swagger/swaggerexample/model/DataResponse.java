package com.rga.swagger.swaggerexample.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "The data response object")
public class DataResponse<T> {
    @ApiModelProperty(notes = "HTTP response code", dataType = "Long", example = "200")
    private long responseCode;

    @ApiModelProperty(notes = "HTTP status", dataType = "Long", example = "Success")
    private long status;

    @ApiModelProperty(notes = "List of attribute objects", dataType = "[com.rga.swagger.swaggerexample.model.Attributes")
    private List<T> records;
}
