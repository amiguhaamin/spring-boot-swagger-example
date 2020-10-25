package com.rga.swagger.swaggerexample.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class Response {

    @ApiModelProperty(notes = "", dataType = "String")
    String message;

    @ApiModelProperty(notes = "", dataType = "Boolean", hidden = true, example = "False")
    boolean success;

    @ApiModelProperty(notes = "", dataType = "[Ljava.lang.String]", example = " { \"jdcdks jdcdsl sncds\"} ")
    List<String> value;

    String id;

}
