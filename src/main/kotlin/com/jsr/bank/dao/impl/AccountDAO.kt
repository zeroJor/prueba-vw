package com.jsr.bank.dao.impl

import com.jsr.bank.dao.IAccountDAO
import com.jsr.bank.data.Balance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update


@Repository
open class AccountDAO @Autowired constructor(private val mongoOperations: MongoOperations): IAccountDAO {

    override fun findBalance(account: Long): Balance? {
        // find by account
        val criteria = Criteria.where(Balance::account.name).`is`(account)
        return mongoOperations.findOne(Query(criteria), Balance::class.java)
    }

    override fun updateBalance(account: Long, amount: Double) {
        // update amount value
        val criteria = Criteria.where(Balance::account.name).`is`(account)
        val update = Update().apply { set(Balance::amount.name, amount) }
        mongoOperations.updateFirst(Query(criteria), update, Balance::class.java)
    }

}