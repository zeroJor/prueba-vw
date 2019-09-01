package com.jsr.bank.data

import com.fasterxml.jackson.annotation.JsonIgnore
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@ApiModel(value = "Balance", description = "Account balance")
@Document(collection = "balance")
data class Balance(
        @JsonIgnore @Id var id: ObjectId,
        @ApiModelProperty(required = true) var account: Long,
        @ApiModelProperty(required = true) var balance: Double,
        @ApiModelProperty(required = true) var owner: Long,
        @ApiModelProperty(required = true) var createdAt: Date) {

    companion object {

        const val MIN_BALANCE = -500.0
    }
}