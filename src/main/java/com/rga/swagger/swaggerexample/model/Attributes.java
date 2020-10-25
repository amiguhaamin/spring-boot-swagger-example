package com.rga.swagger.swaggerexample.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@ApiModel(description = "The attributes")
public class Attributes<T> {

    @ApiModelProperty(notes = "The id", dataType = "String", example = "1234")
    String id;

    @ApiModelProperty(notes = "The username", dataType = "String", example = "testUser")
    String username;

    @ApiModelProperty(notes = "The location", dataType = "String", example = "USA")
    String location;
}
