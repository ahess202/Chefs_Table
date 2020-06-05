package org.launchcode.chefs_table.models.dto;

import org.launchcode.chefs_table.models.dto.LoginFormDTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterFormDTO extends LoginFormDTO {


    @NotNull
    @NotBlank(message = "Must verify password!")
    private String verifyPassword;

    @NotBlank(message = "Must provide an email!")
    @Email
    private String email;


    private String profilePicture;

    private String bio;

    @NotBlank(message = "Must enter a first name!")
    private String firstName;

    private String lastName;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
