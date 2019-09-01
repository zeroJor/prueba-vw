package com.jsr.bank.errors

class MinAmountException(amount: Double): TransactionException("Transaction balance must be up to $amount")