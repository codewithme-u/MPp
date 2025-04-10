package com.mp.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "institutions")
public class Institutions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "institute_name")
    private String institute_name;

    @Column(name = "institute_location")
    private String institute_location;

    @Lob
    @Column(name = "institute_image", columnDefinition = "LONGTEXT")
    private String institute_image;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at;

    // Default constructor
    public Institutions() {
        super();
    }

    // Parameterized constructor
    public Institutions(int id, String institute_name, String institute_location, String institute_image,
                        LocalDateTime created_at) {
        this.id = id;
        this.institute_name = institute_name;
        this.institute_location = institute_location;
        this.institute_image = institute_image;
        this.created_at = created_at;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitute_name() {
        return institute_name;
    }

    public void setInstitute_name(String institute_name) {
        this.institute_name = institute_name;
    }

    public String getInstitute_location() {
        return institute_location;
    }

    public void setInstitute_location(String institute_location) {
        this.institute_location = institute_location;
    }

    public String getInstitute_image() {
        return institute_image;
    }

    public void setInstitute_image(String institute_image) {
        this.institute_image = institute_image;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
