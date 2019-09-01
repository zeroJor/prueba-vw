package com.jsr.bank.errors

class MinAmountException(amount: Double): TransactionException("Transaction amount must be up to $amount")