package com.faustov.tariff.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role extends BaseEntity implements Serializable{
 
 private String name;
 
 @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
 private List<User> users;
 
 @Override
   public String toString() {
     return "Role{" +
             "name=" + name +
             '}';
   }
}