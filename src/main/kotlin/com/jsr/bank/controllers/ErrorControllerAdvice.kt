package com.jsr.bank.controllers

import com.jsr.bank.errors.AccountNotFoundException
import com.jsr.bank.errors.TransactionException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletResponse


@ControllerAdvice
class ErrorControllerAdvice {

    /**
     * If a transaction exception happen, return the respectively HTTP status code and response body
     */
    @ExceptionHandler(TransactionException::class)
    fun handleExceptions(e: TransactionException, response: HttpServletResponse) {
        response.sendError(matchHttpStatus(e).value(), e.message)
    }

    /**
     * Match exception with the related HTTP Status
     */
    private fun matchHttpStatus(e: TransactionException) = when (e) {

        is AccountNotFoundException -> HttpStatus.NOT_FOUND

        else -> HttpStatus.INTERNAL_SERVER_ERROR
    }
}