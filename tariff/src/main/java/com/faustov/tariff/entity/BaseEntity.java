package com.faustov.tariff.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable{
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(nullable = false, updatable = false,columnDefinition = "serial")
 protected Long id;
 
 @CreatedDate
 protected LocalDate created;
 
 @LastModifiedDate
 protected LocalDate updated;
 
 @Enumerated(EnumType.STRING)
 protected Status status;
}
