package com.example.springemail.service;

import com.example.springemail.model.SendNotificationRequest;
import com.example.springemail.model.SendNotificationResponse;

public interface EmailService {

    SendNotificationResponse sendNotification(SendNotificationRequest notificationRequest);
}
