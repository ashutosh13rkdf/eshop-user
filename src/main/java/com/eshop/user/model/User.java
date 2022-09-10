package com.eshop.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="user_name")
    private String userName;
    @Column(name="upassword")
    private String password;
    @Column(name="user_fname")
    private String fname;
    @Column(name="user_lname")
    private String lname;
    @Transient
    @Column(name="created_at")
    private String createdAt;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<Address> address;
}
