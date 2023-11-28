package com.cps714.webApp.models;

import lombok.Data;

//Session User used to manage the session
@Data
public class SessionUser {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

}
