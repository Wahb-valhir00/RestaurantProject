package com.elife.projet_ff.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Builder
@Data
@Getter@Setter@NoArgsConstructor@AllArgsConstructor@ToString
@Document(collection ="User")

public class User {
    private String id;
    @Field(name = "name")
    private String name;
    @Field(name = "Email")
    private String email;
    @Field("Password")
    private String password;
    @Field("Phone")
    private String phone;
    
}
