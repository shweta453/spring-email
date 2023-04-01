package com.example.springemail.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "email_template")
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class EmailTemplate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long templateId;

	@Column(name = "code")
	private String code;

	@Column(name = "subject")
	private String subject;

	@Lob
	@Column(name = "body")
	private String body;

	@Column(name = "html_format")
	private boolean htmlFormat;

}
