package com.faustov.tariff.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.faustov.tariff.entity.Tariff;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TariffDto {
  private Long id; 
  private String name;
  private int speed;
  private int price;
  private boolean wifi;
  private String imageUrl;
  
  public Tariff toTariff() {
    Tariff tariff = new Tariff();
   
    tariff.setId(id);
    tariff.setName(name);
    tariff.setImageUrl(imageUrl);
    tariff.setPrice(price);
    tariff.setSpeed(speed);
    tariff.setWifi(wifi);
    
    return tariff;
  }
  
  public static TariffDto fromTariff(Tariff tariff) {
    TariffDto tariffDto = new TariffDto();
   
    tariffDto.setId(tariff.getId());
    tariffDto.setName(tariff.getName());
    tariffDto.setImageUrl(tariff.getImageUrl());
    tariffDto.setPrice(tariff.getPrice());
    tariffDto.setSpeed(tariff.getSpeed());
    tariffDto.setWifi(tariff.isWifi());
 
    return tariffDto;
  }
}