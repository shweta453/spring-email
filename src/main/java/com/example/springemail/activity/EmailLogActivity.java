package com.example.springemail.activity;

import com.example.springemail.entity.EmailLog;
import com.example.springemail.model.FindPendingEmails;

import java.util.List;

public interface EmailLogActivity {

    EmailLog addEmailLog(EmailLog emailLog);


    EmailLog updateEmailLog(EmailLog emailLog);

}
