package com.example.demo.controller

import com.example.demo.entity.Feedback
import com.example.demo.repository.FeedbackRepository
import com.example.demo.entity.Request
import com.example.demo.initDB.Load
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/feedback")
class RequestController private constructor(private var repository: FeedbackRepository) {

    companion object {
        private val log: Logger = LoggerFactory.getLogger(Load::class.java)
    }

    @PostMapping
    private fun addFeedback(@CookieValue("user_id") user_id: String,
                    @RequestBody newRequest: Request): ResponseEntity<Request> {
        log.info("Post")
        if (newRequest.method == "add_feedback"){
            addFeedback(user_id, newRequest.params)
        }
        return ResponseEntity.ok(newRequest)
    }

    @GetMapping
    private fun getAllFeedback(@CookieValue("user_id") user_id: String): List<Feedback?> {
        return repository.findAll()
    }

    private fun addFeedback(user_id: String, text: String): Feedback {
        val feedback = Feedback(user_id, text)
        return repository.save(feedback)
    }

}
