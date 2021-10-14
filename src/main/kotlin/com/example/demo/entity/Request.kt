package com.example.demo.entity

import java.util.*
import javax.persistence.*


@Entity
class Request(@Id var method: String,
              var params: String) {

    override fun hashCode(): Int {
        return Objects.hash(this.method, this.params)
    }

    override fun toString(): String {
        return "Request{$method, $params}"
    }
}
