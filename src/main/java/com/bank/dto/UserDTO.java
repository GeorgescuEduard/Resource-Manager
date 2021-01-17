package com.bank.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDTO {

    private Long userid;

    @NotBlank(message = "The first name can not be empty.")
    @Size(max = 48,min = 6 ,message = "The first name must have 6-48 characters.")
    private String firstname;

    @NotBlank(message = "The last name can not be empty.")
    @Size(max = 48, min = 6, message = "The last name must have 6-48 characters.")
    private String lastname;

    @NotBlank(message = "The user name can not be empty.")
    @Size(max = 48, min = 6, message = "The username must have 6-48 characters.")
    private String username;

    @NotBlank(message = "The email can not be empty.")
    @Email(message = "The user email is invalid")
    private String email;

    @NotBlank(message = "The password can not be empty.")
    @Size(max = 32, min = 6, message = "The password must have 6-48 characters.")
    private String password;

    public UserDTO(){ }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
