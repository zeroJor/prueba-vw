package com.jsr.bank.dao

import com.jsr.bank.data.Balance

interface IAccountDAO {

    /**
     * Find the current balance of a specific account
     * @param account
     * @return balance or null
     */
    fun findBalance(account: Long): Balance?

    /**
     * Update the amount balance for a specific account
     * @param account
     * @param amount
     */
    fun updateBalance(account: Long, amount: Double)
}