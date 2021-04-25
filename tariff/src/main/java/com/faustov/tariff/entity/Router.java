package com.faustov.tariff.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Router extends BaseEntity implements Serializable{
  private String name;
  private String description;
  private String company;
  private int price;
  private String imageUrl;
}
