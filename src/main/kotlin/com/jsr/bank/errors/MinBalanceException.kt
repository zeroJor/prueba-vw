package com.jsr.bank.errors

class MinBalanceException(amount: Double): TransactionException("Origin account shouldn't be able to have a balance below $amount")