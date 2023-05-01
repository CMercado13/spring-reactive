package com.reactive.wf.model.client;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Client {

    private String id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String urlPhoto;
}
