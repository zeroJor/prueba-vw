package com.jsr.bank.controllers

import com.jsr.bank.services.IAccountServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {

    @Autowired
    private lateinit var accountServices: IAccountServices

    /**
     * Redirecto to API UI documentation
     * @param account
     */
    @GetMapping("/")
    private fun home() = "redirect:/swagger-ui.html"
}