package com.example.springemail.repository;

import com.example.springemail.entity.EmailLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailLogRepository extends JpaRepository<EmailLog, Long> {
    List<EmailLog> findAllByStatusContentAndSubjectIn(String statusContent, List<String> subject);
}
