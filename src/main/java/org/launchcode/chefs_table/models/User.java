package org.launchcode.chefs_table.models;

import com.sun.istack.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;

@Entity
public class User extends AbstractEntity {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String profilePicture;

    private String bio;

    private boolean isVerifiedChef = false;

    public User() {}

    public User(String username, String password, String email, String profilePicture, String bio, String firstName, String lastName) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.email = email;
        this.profilePicture = profilePicture;
        this.bio = bio;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean getVerifiedStatus() {
        return isVerifiedChef;
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

    public void markAsVerified() {
        this.isVerifiedChef = true;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }
}

