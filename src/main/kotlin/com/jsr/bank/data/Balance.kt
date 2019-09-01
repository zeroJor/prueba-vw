package com.jsr.bank.data

import com.fasterxml.jackson.annotation.JsonIgnore
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "balance")
data class Balance(
        @JsonIgnore @Id var id: ObjectId,
        var account: Long,
        var amount: Double) {

    companion object {

        const val MIN_BALANCE = -500.0
    }
}