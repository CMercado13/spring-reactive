package com.reactive.wf.model.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Client {

    private String id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String urlPhoto;
}
