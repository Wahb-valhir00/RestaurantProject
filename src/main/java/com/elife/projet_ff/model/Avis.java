package com.elife.projet_ff.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "Avis")

public class Avis {
    @Id
    private String id;
    private User user;
    private Restaurant restaurant;
    private int note;
    private String comment;
    

    
}
