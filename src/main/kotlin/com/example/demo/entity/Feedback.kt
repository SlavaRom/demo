package com.example.demo.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id


@Entity
class Feedback(@Id var user_id: String,
               var message_text: String) {

    override fun hashCode(): Int {
        return Objects.hash(this.user_id, this.message_text)
    }

    override fun toString(): String {
        return "feedback{$user_id, $message_text}"
    }
}
