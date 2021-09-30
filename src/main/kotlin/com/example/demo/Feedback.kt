package com.example.demo

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*
import javax.persistence.*
import javax.persistence.Id

internal interface FeedbackRepository : JpaRepository<Feedback?, Long?>

@Entity
class Feedback {
    @Id
    private lateinit var user_id: String
    private lateinit var message_text: String

    override fun hashCode(): Int {
        return Objects.hash(this.user_id, this.message_text)
    }

    constructor() {}

    constructor(
            user_id: String,
            message: String) {
        this.user_id = user_id
        this.message_text = message
    }

    fun getUser_id(): String {
        return this.user_id
    }

    fun getMessage_text(): String {
        return this.message_text
    }

    fun setUser_id(user_id: String) {
        this.user_id = user_id
    }

    fun setMessage_text(message_text: String) {
        this.message_text = message_text
    }

    override fun toString(): String {
        return "feedback{$user_id, $message_text}"
    }
}