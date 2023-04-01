package com.example.springemail.controller;

import com.example.springemail.constant.SPMSAPIConstants;
import com.example.springemail.entity.EmailLog;
import com.example.springemail.entity.EmailTemplate;
import com.example.springemail.model.FindPendingEmails;
import com.example.springemail.model.SendNotificationRequest;
import com.example.springemail.model.SendNotificationResponse;
import com.example.springemail.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = SPMSAPIConstants.API_BASE_URL)
public class MailServiceController {

    @Autowired
    private EmailService emailService;


    @PostMapping(path = SPMSAPIConstants.MAIL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<SendNotificationResponse> sendNotification(@RequestBody SendNotificationRequest notificationRequest) {
        SendNotificationResponse notificationResponse = emailService.sendNotification(notificationRequest);
        return new ResponseEntity<SendNotificationResponse>(notificationResponse, HttpStatus.OK);
    }

}
