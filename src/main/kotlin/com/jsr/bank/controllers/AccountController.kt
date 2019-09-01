package com.jsr.bank.controllers

import com.jsr.bank.data.Balance
import com.jsr.bank.data.Transaction
import com.jsr.bank.services.IAccountServices
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/account"])
class AccountController {

    @Autowired
    private lateinit var accountService: IAccountServices

    @ApiOperation(
            value = "Transfer money from one account to another",
            notes = "fromAccount, toAccount and amount values are required")
    @PostMapping("/transfer")
    private fun transfer(@RequestBody transaction: Transaction) = accountService.transfer(transaction)

    @ApiOperation(
            value = "Provide full transaction history for an specific account",
            notes = "Use 'type' parameter in order to filter transactions",
            response = Transaction::class)
    @GetMapping("/{account}/history")
    private fun history(
            @ApiParam(value = "The account identifier")
            @PathVariable(value = "account") account: Long,
            @ApiParam(value = "S for sent, R for received, None for all", required = false, allowableValues = "S, R")
            @RequestParam(value = "type", required = false) type: String? = null): List<Transaction> {

        return accountService.loadHistory(account, type)
    }

    @ApiOperation(
            value = "Provide current balance for an specific account",
            response = Balance::class)
    @GetMapping("/{account}/balance")
    private fun balance(
            @ApiParam(value = "The account identifier")
            @PathVariable("account") account: Long) = accountService.loadBalance(account)

}