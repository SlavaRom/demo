package com.example.demo.repository

import com.example.demo.entity.Request
import org.springframework.data.jpa.repository.JpaRepository


internal interface RequestRepository : JpaRepository<Request?, Long?>
