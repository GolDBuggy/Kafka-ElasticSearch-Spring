package com.java.spring.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.elasticsearch.index.engine.Engine;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.annotation.processing.Generated;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Document(indexName = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(value = "user entity",description = "User Model")
public class User {

    @Id
    @Field(type = FieldType.Text,name = "user_id")
    @ApiModelProperty(value = "String id ")
    private String id;

    @Field(type = FieldType.Text,name = "username")
    @ApiModelProperty(value = "isim")
    private String name;

    @Field(type = FieldType.Text,name = "user_address")
    @ApiModelProperty(value = "adres")
    private String address;

    @Field(type = FieldType.Double_Range,name = "money")
    @ApiModelProperty(value = "para")
    private BigDecimal money;

    @Field(type = FieldType.Date,name = "birthday")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @ApiModelProperty(value = "dogumgunu")
    private Date birthday;

    @Field(type = FieldType.Nested,name = "features")
    @ApiModelProperty(value = "liste verileri")
    private List features;
}
