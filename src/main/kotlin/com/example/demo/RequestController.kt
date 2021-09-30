package com.example.demo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class RequestController {
    private lateinit var repository: FeedbackRepository

    private constructor(repository: FeedbackRepository) {
        this.repository = repository
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(Load::class.java)
    }

    @PostMapping("/feedback")
    fun addFeedback(@CookieValue("user_id") user_id: String,
                    @RequestBody newRequest: Request): ResponseEntity<Request> {
        log.info("Post")
        if (newRequest.getMethod() == "add_feedback"){
            addFeedback(user_id, newRequest.getParams())
        }
        return ResponseEntity.ok(newRequest)
    }

    @GetMapping("/feedback")
    private fun getAllFeedback(@CookieValue("user_id") user_id: String): List<Feedback?> {
        return repository.findAll()
    }

    private fun addFeedback(user_id: String, text: String): Feedback {
        val feedback = Feedback(user_id, text)
        return repository.save(feedback)
    }

}