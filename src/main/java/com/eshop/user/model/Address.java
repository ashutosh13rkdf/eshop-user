package com.eshop.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    @Column(name="line1")
    private String line1;
    @Column(name="line2")
    private String line2;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;
    @Column(name="zip")
    private String zip;
    @Column(name="country")
    private String country;
    @Transient
    @Column(name="created_at")
    private String createdAt;
}
