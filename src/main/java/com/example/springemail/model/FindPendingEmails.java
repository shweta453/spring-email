package com.example.springemail.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class FindPendingEmails {

    private String statusContent;
    private List<String> subject;

}
