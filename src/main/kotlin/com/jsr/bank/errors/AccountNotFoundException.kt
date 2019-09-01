package com.jsr.bank.errors

class AccountNotFoundException(account: Long?): TransactionException("The account $account does not exist")