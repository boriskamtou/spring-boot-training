package com.optimagrowth.license.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name = "licenses")
@Getter @Setter @ToString
public class License extends RepresentationModel<License> {
    @Id
    @Column(name = "licence_id", nullable = false)
    private String licenseId;
    private String description;
    @Column(name = "organization_id", nullable = false)
    private String organizationId;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "license_type", nullable = false)
    private String licenseType;
    @Column(name = "comment")
    private String comment;

    public License withComment(String comment){
        this.setComment(comment);
        return this;
    }
}
