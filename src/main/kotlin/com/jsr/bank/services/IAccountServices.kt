package com.jsr.bank.services

import com.jsr.bank.errors.MinBalanceException
import com.jsr.bank.errors.AccountNotFoundException
import com.jsr.bank.data.Balance
import com.jsr.bank.data.Transaction

interface IAccountServices {

    /**
     * Transfer money from one account to another.
     * An account shouldn't be able to have a balance below $ -500.00
     * @param transaction contains the transaction details
     * @throws MinBalanceException
     */
    @Throws(MinBalanceException::class, AccountNotFoundException::class)
    fun transfer(transaction: Transaction)

    /**
     * Recover the current balance of a specific account
     * @param account account identifier
     */
    @Throws(AccountNotFoundException::class)
    fun loadBalance(account: Long): Balance

    /**
     * Recover the transaction history from an account
     * @param account account identifier
     * @param type if presented, filter by transaction type
     */
    @Throws(AccountNotFoundException::class)
    fun loadHistory(account: Long, type: String?): List<Transaction>
}