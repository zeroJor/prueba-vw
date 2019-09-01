package com.jsr.bank.services.impl

import com.jsr.bank.dao.IAccountDAO
import com.jsr.bank.dao.ITransactionDAO
import com.jsr.bank.data.Balance
import com.jsr.bank.data.Transaction
import com.jsr.bank.errors.AccountNotFoundException
import com.jsr.bank.errors.MinAmountException
import com.jsr.bank.errors.MinBalanceException
import com.jsr.bank.errors.ValidationException
import com.jsr.bank.services.IAccountServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountServices: IAccountServices {

    @Autowired
    private lateinit var transactionDAO: ITransactionDAO

    @Autowired
    private lateinit var accountDAO: IAccountDAO

    override fun transfer(transaction: Transaction) {

        // a transaction cannot be made between the same account
        if (transaction.fromAccount == transaction.toAccount) {
            throw ValidationException("Origin and destination account must be different")
        }

        // both, origin and destination accounts must exist
        val from = loadBalance(transaction.fromAccount!!)
        val to = loadBalance(transaction.toAccount!!)

        // amount must be up to zero
        if (transaction.amount!! <= Transaction.MIN_AMOUNT) {
            throw MinAmountException(Transaction.MIN_AMOUNT)
        }

        // origin account shouldn't be able to have a balance below $ -500.00
        val originFinalAmount = from.amount -  transaction.amount!!
        if (originFinalAmount < Balance.MIN_BALANCE) {
            throw MinBalanceException(Balance.MIN_BALANCE)
        }

        /**
         * Apply transaction:
         * assign transaction date
         * update origin and destination balance
         * insert transaction
         */
        transaction.sentAt = Date()
        accountDAO.updateBalance(from.account, originFinalAmount)
        accountDAO.updateBalance(to.account, to.amount + transaction.amount!!)
        transactionDAO.create(transaction)
    }

    override fun loadBalance(account: Long): Balance {
        // find account balance
        // if it does not exist throw an exception
        return accountDAO.findBalance(account) ?: throw AccountNotFoundException(account)
    }

    override fun loadHistory(account: Long, type: String?) = when (type) {

        Transaction.TYPE_RECEIVED  -> transactionDAO.search(toAccount = account)

        Transaction.TYPE_SENT -> transactionDAO.search(fromAccount = account)

        else -> transactionDAO.searchByAccount(account)
    }

}