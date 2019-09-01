package com.jsr.bank.dao

import com.jsr.bank.data.Transaction

interface ITransactionDAO {

    /**
     * Insert a new transaction
     * @param transaction
     */
    fun create(transaction: Transaction)

    /**
     * Search all transactions related with an account
     * @param account
     * @return the list of transactions
     */
    fun searchByAccount(account: Long): List<Transaction>

    /**
     * Search transactions with filter options
     * @param fromAccount if presented, result is filtered
     * @param toAccount if presented, result is filtered
     * @return the list of transactions
     */
    fun search(fromAccount: Long? = null, toAccount: Long? = null): List<Transaction>
}