package com.faustov.tariff.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity implements Serializable{
 private String username;
 
 private String firstName;
 
 private String lastName;
 
 private String email;
 
 private String password;
 
 @ManyToMany(fetch = FetchType.EAGER)
 @JoinTable( name = "user_roles",
    joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")})
 private List<Role> roles;
 
 @Override
   public String toString() {
     return "User{" +
             "username=" + username +
             '}';
   }
 
}
