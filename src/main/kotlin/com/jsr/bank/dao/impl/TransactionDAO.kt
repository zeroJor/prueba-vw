package com.jsr.bank.dao.impl

import com.jsr.bank.dao.ITransactionDAO
import com.jsr.bank.data.Transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

@Repository
open class TransactionDAO @Autowired constructor(private val mongoOperations: MongoOperations): ITransactionDAO {

    override fun create(transaction: Transaction) {
        mongoOperations.save(transaction)
    }

    override fun searchByAccount(account: Long): List<Transaction> {
        // filter by account, send and received transactions
        val query = Query().apply {
            val criteria = Criteria().orOperator(
                    Criteria.where(Transaction::fromAccount.name).`is`(account),
                    Criteria.where(Transaction::toAccount.name).`is`(account))

            addCriteria( criteria )
        }

        return mongoOperations.find(query, Transaction::class.java)
    }

    override fun search(fromAccount: Long?, toAccount: Long?): List<Transaction> {
        // apply presented filters
        val query = Query().apply {
            fromAccount?.let { addCriteria( Criteria.where(Transaction::fromAccount.name).`is`(it) ) }
            toAccount?.let { addCriteria( Criteria.where(Transaction::toAccount.name).`is`(it) ) }
            with( Sort(Sort.Direction.DESC, Transaction::sentAt.name) )
        }

        return mongoOperations.find(query, Transaction::class.java)
    }

}