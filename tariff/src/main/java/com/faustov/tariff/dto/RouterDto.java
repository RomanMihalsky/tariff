package com.faustov.tariff.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.faustov.tariff.entity.Router;
import com.faustov.tariff.entity.Tariff;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RouterDto {
  private Long id;
  private String name;
  private String description;
  private String company;
  private int price;
  private String imageUrl;

  
  public Router toRouter() {
    Router router = new Router();
   
    router.setId(id);
    router.setName(name);
    router.setImageUrl(imageUrl);
    router.setPrice(price);
    router.setDescription(description);
    router.setCompany(company);
    
    return router;
  }
  
  public static RouterDto fromRouter(Router router) {
    RouterDto routerDto = new RouterDto();
   
    routerDto.setId(router.getId());
    routerDto.setName(router.getName());
    routerDto.setImageUrl(router.getImageUrl());
    routerDto.setPrice(router.getPrice());
    routerDto.setDescription(router.getDescription());
    routerDto.setCompany(router.getCompany());
 
    return routerDto;
  }
}
