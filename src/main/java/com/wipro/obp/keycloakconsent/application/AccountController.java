package com.wipro.obp.keycloakconsent.application;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://docs.spring.io/spring-security/site/docs/3.0.x/reference/el-access.html
 *
 * @author Edward P. Legaspi | czetsuya@gmail.com
 *
 * @since 0.0.1
 * @version 0.0.1
 */
@RestController
//@RequestMapping(path = "/iam/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping(path = "/iam/accounts")
@Validated
public class AccountController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "sudesh hello";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(path = "/authenticated")
    public String authenticated() {
        return "hello";
    }

    @GetMapping(path = "/promoters")
    public String promoters() {
        return "hello world -is valid promoter";
    }

    @GetMapping(path = "/supervisors")
    public String supervisors() {
        return "hello world";
    }
}
