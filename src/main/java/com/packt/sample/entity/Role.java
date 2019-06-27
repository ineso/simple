package com.packt.sample.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {

    public Role () {}

    public Role (String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    private Set<UserAPP> users;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserAPP> getUsers() {
        return users;
    }

    public void setUsers(Set<UserAPP> users) {
        this.users = users;
    }


}
