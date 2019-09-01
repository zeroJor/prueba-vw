package com.jsr.bank.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    /**
     * Redirecto to API UI documentation
     * @param account
     */
    @GetMapping("/")
    private fun home() = "redirect:/swagger-ui.html"

}