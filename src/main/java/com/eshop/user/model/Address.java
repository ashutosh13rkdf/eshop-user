package com.eshop.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name="user_address")
@Getter
@Setter
@NoArgsConstructor
public class Address implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
/*    @ManyToOne(optional=false)
    @JoinColumn(name="user_id")
    private User user;*/
    @NotBlank(message = "line1 is mandatory")
    @Column(name="line1")
    private String line1;
    @Column(name="line2")
    private String line2;
    @NotBlank(message = "city is mandatory")
    @Column(name="city")
    private String city;

    @Column(name="state")
    @NotBlank(message = "state is mandatory")
    private String state;
    @Column(name="zip")
    @NotBlank(message = "zip is mandatory")
    private String zip;
    @Column(name="country")
    @NotBlank(message = "country is mandatory")
    private String country;
    @Transient
    @Column(name="created_at")
    private String createdAt;
}
