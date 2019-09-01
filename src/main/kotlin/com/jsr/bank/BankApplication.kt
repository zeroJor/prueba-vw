package com.jsr.bank

import com.jsr.bank.config.Configuration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import


@Import(Configuration::class)
@SpringBootApplication
open class BankApplication

fun main(args: Array<String>) {
	runApplication<BankApplication>(*args)
}
