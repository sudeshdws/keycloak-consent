package com.wipro.obp.keycloakconsent.business.service;

import lombok.Data;

import java.util.List;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Data
public class CurrentUser {

    private String username;
    private List<String> roles;
}
