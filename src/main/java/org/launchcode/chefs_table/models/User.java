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

    private String email;

    private String profilePicture;

    private String bio;

    private boolean isVerifiedChef = false;

    public User() {}

    public User(String username, String password, String email, String profilePicture, String bio) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.email = email;
        this.profilePicture = profilePicture;
        this.bio = bio;
    }

    public String getUsername() {
        return username;
    }

    public boolean getVerifiedStatus() {
        return isVerifiedChef;
    }

    public void markAsVerified() {
        this.isVerifiedChef = true;
    }
}

