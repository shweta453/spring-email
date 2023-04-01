package com.example.springemail.service.impl;


import com.example.springemail.activity.EmailLogActivity;
import com.example.springemail.entity.EmailLog;
import com.example.springemail.entity.EmailTemplate;
import com.example.springemail.model.NotificationParameter;
import com.example.springemail.model.SendNotificationRequest;
import com.example.springemail.model.SendNotificationResponse;
import com.example.springemail.repository.EmailTemplateRepository;
import com.example.springemail.service.EmailService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailLogActivity emailLogActivity;

    @Autowired
    private EmailTemplateRepository emailTemplateRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public SendNotificationResponse sendNotification(SendNotificationRequest notificationRequest) {
        Optional<EmailTemplate> emailTemplateOptional = emailTemplateRepository.findByCode(notificationRequest.getTemplateCode());
        SendNotificationResponse sendNotificationResponse=null;
        if(emailTemplateOptional.isPresent()) {
            EmailTemplate emailTemplate = emailTemplateOptional.get();

            List<NotificationParameter> notificationParameters = notificationRequest.getParameters();

            //jo list me tha data use map me convert kiya
            Map<String, String> parameters = notificationParameters.stream().collect(Collectors.toMap(NotificationParameter::getKey, NotificationParameter::getValue));

            //replacing dynamic fields in template with values
            final String body = getContent(emailTemplate.getBody(), parameters);

            //setting in email log for sending mail
            EmailLog emailLog = EmailLog.builder()
                    .toEmail("sdm23231470@gmail.com")
                    .body(body)
                    .status(0)
                    .statusContent("pending")
                    .subject(emailTemplate.getSubject())
                    .code(emailTemplate.getCode())
                    .htmlFormat(emailTemplate.isHtmlFormat())
                    .build();
            emailLog =  emailLogActivity.addEmailLog(emailLog);
            System.out.println(emailLog);
            emailLog = sendMail(emailLog);

            emailLogActivity.updateEmailLog(emailLog);

           sendNotificationResponse = SendNotificationResponse.builder().resultCode("0").resultDisc("Success").build();
        }
        return sendNotificationResponse;
    }

    @SneakyThrows
    private EmailLog sendMail(EmailLog emailLog){
            javax.mail.internet.MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setFrom("sdm23231470@gmail.com");
            helper.setTo(emailLog.getToEmail());
            helper.setSubject(emailLog.getSubject());
            helper.setText(emailLog.getBody(), true);
            mailSender.send(mimeMessage);
        emailLog.setStatus(1);
        emailLog.setStatusContent("COMPLETED");
            return emailLog;
        }

    private String getContent(String content, Map<String, String> parameters) {
        if (content.contains("<<STUDENT_NAME>>")) {
            //means content/template me jo <<STUDENT_NAME>> use value se replace karna
            content = StringUtils.replace(content, "<<STUDENT_NAME>>", getValue(parameters, "STUDENT_NAME"));
        }
        return content;
    }

    private String getValue(Map<String, String> parameters, String key) {
        return parameters.containsKey(key) ? parameters.get(key) : "";
    }
}