package com.example.springemail.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "email_logs")
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmailLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "message_id")
	private int messageId;

	@Column(name = "to_email")
	private String toEmail;

	@Column(name = "code")
	private String code;

	@Column(name = "subject")
	private String subject;

	@Lob
	@Column(name = "body")
	private String body;

	@Column(name = "html_format")
	private boolean htmlFormat;

	@Column(name = "STATUS")
	private Integer status;

	@Column(name = "STATUS_CONTENT")
	private String statusContent;

	@CreationTimestamp
	@Column(name = "CREATED_DATE")
	private Timestamp createdDate;

	@LastModifiedDate
	@Column(name = "PROCESSED_DATE")
	private Timestamp processedDate;
}
