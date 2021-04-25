package com.faustov.tariff.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Tariff extends BaseEntity implements Serializable{
  private String name;
  private int speed;
  private int price;
  private boolean wifi;
  private String imageUrl;
}
