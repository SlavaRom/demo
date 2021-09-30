package com.example.demo

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*
import javax.persistence.*


internal interface RequestRepository : JpaRepository<Request?, Long?>

@Entity
class Request {
    @Id
    private lateinit var method: String
    private lateinit var params: String

    override fun hashCode(): Int {
        return Objects.hash(this.method, this.params)
    }

    constructor() {}

    constructor(
            method: String,
            params: String) {
        this.method = method
        this.params = params
    }

    fun getMethod(): String {
        return this.method
    }

    fun getParams(): String {
        return this.params
    }

    fun setMethod(method: String) {
        this.method = method
    }

    fun setParams(params: String) {
        this.params = params
    }

    override fun toString(): String {
        return "Request{$method, $params}"
    }
}