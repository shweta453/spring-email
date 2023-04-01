package com.example.springemail.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class SendNotificationResponse {

    private String resultCode;
    private String resultDisc;
}
