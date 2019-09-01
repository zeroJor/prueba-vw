package com.jsr.bank.config

import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableSwagger2
@EnableMongoRepositories(basePackages = [ "com.jsr.bank" ])
class Configuration {

    // use our own Docket configuration instance
    @Bean
    fun provideDocket(apiInfo: ApiInfo) = Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.jsr.bank"))
            .paths(PathSelectors.regex("/api.*"))
            .build()
            .apiInfo(apiInfo)

    // use our custom api info
    @Bean
    fun provideApiInfo() = ApiInfo(
            "Digital Hub - Backend Assignment - CP",
            "API for transfer money and show the past transactions in a historical transaction list",
            "1.0.0",
            "Free to use ;)",
            Contact("Jorge Segundo Rojas", "https://github.com/zeroJor/prueba-vw", "jorgesr@live.com.mx"),
            null,
            null)

}