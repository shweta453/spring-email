package com.example.springemail.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class NotificationParameter {

	private String key;
	private String value;

}
