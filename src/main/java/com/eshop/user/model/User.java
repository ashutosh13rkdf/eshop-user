package com.eshop.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "userName is mandatory")
    private String userName;
    @Column(name="upassword")
    @NotBlank(message = "password is mandatory")
    private String password;
    @Column(name="user_fname")
    @NotBlank(message = "fname is mandatory")
    private String fname;
    @Column(name="user_lname")
    @NotBlank(message = "lname is mandatory")
    private String lname;
    @Transient
    @Column(name="created_at")
    private String createdAt;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    @Valid
    private Set<Address> address;
}
