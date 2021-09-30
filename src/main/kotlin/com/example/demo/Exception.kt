package com.example.demo

import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MissingRequestCookieException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus


@ControllerAdvice
internal class EmployeeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(MissingRequestCookieException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun CookieNotFound(ex: MissingRequestCookieException): String? {
        val r1 = Regex("'.+'")
        return "В cookie не указан " + r1.find(ex.message)?.value
    }

    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun JsonNotFound(ex: HttpMessageNotReadableException): String? {
        return "Ошибка с json в body"
    }
}
