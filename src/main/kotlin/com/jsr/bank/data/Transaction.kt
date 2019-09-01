package com.jsr.bank.data

import com.fasterxml.jackson.annotation.JsonIgnore
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@ApiModel(value = "Transaction", description = "Money transaction between two acounts")
@Document(collection = "transactions")
data class Transaction(
        @JsonIgnore @Id var id: ObjectId? = null,
        @ApiModelProperty(required = true) var fromAccount: Long? = null,
        @ApiModelProperty(required = true) var toAccount: Long? = null,
        @ApiModelProperty(required = true) var amount: Double? = null,
        var sentAt: Date? = null) {

    companion object {

        const val TYPE_RECEIVED = "R"

        const val TYPE_SENT = "S"

        const val MIN_AMOUNT = 0.0
    }
}