package com.example.springemail.activity.impl;

import com.example.springemail.activity.EmailLogActivity;
import com.example.springemail.entity.EmailLog;
import com.example.springemail.model.FindPendingEmails;
import com.example.springemail.repository.EmailLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailLogActivityImpl implements EmailLogActivity {

    @Autowired
    private EmailLogRepository emailLogRepository;

    @Override
    public EmailLog addEmailLog(EmailLog emailLog) {
        return emailLogRepository.save(emailLog);
    }

    @Override
    public EmailLog updateEmailLog(EmailLog emailLog) {
        return emailLogRepository.save(emailLog);
    }

}
