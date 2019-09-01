package com.jsr.bank.data

import com.fasterxml.jackson.annotation.JsonIgnore
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "transactions")
data class Transaction(
        @JsonIgnore @Id var id: ObjectId? = null,
        var fromAccount: Long? = null,
        var toAccount: Long? = null,
        var amount: Double? = null,
        var sentAt: Date? = null) {

    companion object {

        const val TYPE_RECEIVED = "R"

        const val TYPE_SENT = "S"

        const val MIN_AMOUNT = 0.0
    }
}