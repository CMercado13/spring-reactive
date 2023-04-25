package com.reactive.wf.mongo.dish;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "dishes")
public class DishDB {

    @Id
    @EqualsAndHashCode.Include
    private String id; //ObjectId | BSON Binary JSON

    @Field //(name = "namex") //ES OPCIONAL
    private String name;

    @Field
    private Double price;

    @Field
    private Boolean status;
}
