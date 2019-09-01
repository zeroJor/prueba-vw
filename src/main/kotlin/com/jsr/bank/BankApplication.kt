package com.jsr.bank

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories


@Import(Configuration::class)
@SpringBootApplication
open class BankApplication

@EnableMongoRepositories(basePackages = [ "com.jsr.bank" ])
class Configuration

fun main(args: Array<String>) {
	runApplication<BankApplication>(*args)
}
