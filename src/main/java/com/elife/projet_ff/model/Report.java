package com.elife.projet_ff.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Document(collection = "reports")
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class Report {
    @Id
    private String id;
    @Field(name = "user")
    private User user;
    @Field(name = "restaurant")
    private Restaurant restaurant;
    @Field(name = "message")
    private String message;
    
}
