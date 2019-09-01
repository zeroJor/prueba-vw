package com.jsr.bank.controllers

import com.jsr.bank.data.Transaction
import com.jsr.bank.services.IAccountServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/account"])
class AccountController {

    @Autowired
    private lateinit var accountService: IAccountServices

    /**
     * Transfer money from one account to another
     * @param account
     */
    @PostMapping("/transfer")
    private fun transfer(@RequestBody transaction: Transaction) = accountService.transfer(transaction)

    /**
     * Provide current balance for an specific account
     * @param account
     */
    @GetMapping("/{account}/balance")
    private fun balance(@PathVariable("account") account: Long) = accountService.loadBalance(account)

    /**
     * Provide full transaction history for an specific account
     * @param account
     * @param type if presented, applies filter to result
     */
    @GetMapping("/{account}/history")
    private fun history(
            @PathVariable(value = "account") account: Long,
            @RequestParam(value = "type", required = false) type: String? = null): List<Transaction> {

        return accountService.loadHistory(account, type)
    }
}