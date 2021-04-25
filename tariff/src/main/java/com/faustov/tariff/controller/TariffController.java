package com.faustov.tariff.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faustov.tariff.dto.TariffDto;
import com.faustov.tariff.entity.Tariff;
import com.faustov.tariff.service.TariffService;

@RestController
@RequestMapping(value = "/tariff")
public class TariffController {
  
  private TariffService tariffService;

  @Autowired
  public TariffController(TariffService tariffService) {
    this.tariffService = tariffService;
  }
  
  @GetMapping
  public ResponseEntity<List<TariffDto>> findAllTariffs(){
    List<Tariff> result = tariffService.getAll();
    
    if (result == null) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    List<TariffDto> tariffDto = new ArrayList<TariffDto>();
    
    for (int i = 0; i < result.size(); i++) {
      tariffDto.add(TariffDto.fromTariff(result.get(i)));
    }
    
    return new ResponseEntity<>(tariffDto, HttpStatus.OK);
  }
  
  @GetMapping("/{tariffId}")
  public ResponseEntity<TariffDto> findByID(@PathVariable Long tariffId){
    Tariff tariff = tariffService.findById(tariffId);

    if(tariff == null){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    TariffDto result = TariffDto.fromTariff(tariff);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<TariffDto> save(@RequestBody TariffDto tariffDto){
    if(tariffDto == null){
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }  
   
    Tariff tariff = tariffDto.toTariff();  
   
    tariff.setId(0L);
    
    tariffService.save(tariff);

    return new ResponseEntity<>(tariffDto, HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<TariffDto> update(@RequestBody TariffDto tariffDto){
    if(tariffDto == null){
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }    
 
    Tariff tariff = tariffDto.toTariff(); 
 
    tariffService.save(tariff);

    return new ResponseEntity<>(tariffDto, HttpStatus.OK);
  }

  @DeleteMapping("/{tariffId}")
  public ResponseEntity<String> delete(@PathVariable Long tariffId){
    Tariff tariff = tariffService.findById(tariffId);

    if(tariff == null){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }  

    tariffService.delete(tariff);

    return new ResponseEntity<>("Deleted tariff id - " + tariffId, HttpStatus.OK);
  }
}
