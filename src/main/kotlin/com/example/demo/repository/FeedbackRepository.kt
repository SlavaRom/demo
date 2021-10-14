package com.example.demo.repository

import com.example.demo.entity.Feedback
import org.springframework.data.jpa.repository.JpaRepository


internal interface FeedbackRepository : JpaRepository<Feedback?, Long?>
