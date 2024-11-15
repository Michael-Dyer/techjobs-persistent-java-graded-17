package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Employer extends AbstractEntity {

    public Employer(){

    }

    @NotBlank
    @Size(min = 2, max = 150)
    private String location;




    public @NotBlank @Size(min = 2, max = 150) String getLocation() {
        return location;
    }

    public void setLocation(@NotBlank @Size(min = 2, max = 150) String location) {
        this.location = location;
    }
}
