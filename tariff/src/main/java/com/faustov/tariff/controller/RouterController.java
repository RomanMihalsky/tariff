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

import com.faustov.tariff.dto.RouterDto;
import com.faustov.tariff.entity.Router;
import com.faustov.tariff.service.RouterService;

@RestController
@RequestMapping(value = "/router")
public class RouterController {
  
  private RouterService routerService;

  @Autowired
  public RouterController(RouterService routerService) {
    this.routerService = routerService;
  }
  
  @GetMapping
  public ResponseEntity<List<RouterDto>> findAllRouters(){
    List<Router> result = routerService.getAll();
    
    if (result == null) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    List<RouterDto> routerDto = new ArrayList<RouterDto>();
    
    for (int i = 0; i < result.size(); i++) {
      routerDto.add(RouterDto.fromRouter(result.get(i)));
    }
    
    return new ResponseEntity<>(routerDto, HttpStatus.OK);
  }
  
  @GetMapping("/{routerId}")
  public ResponseEntity<RouterDto> findByID(@PathVariable Long routerId){
    Router router = routerService.findById(routerId);

    if(router == null){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    RouterDto result = RouterDto.fromRouter(router);

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<RouterDto> save(@RequestBody RouterDto routerDto){
    if(routerDto == null){
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }  
   
    Router router = routerDto.toRouter();  
   
    router.setId(0L);
    
    routerService.save(router);

    return new ResponseEntity<>(routerDto, HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<RouterDto> update(@RequestBody RouterDto routerDto){
    if(routerDto == null){
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }    
 
    Router router = routerDto.toRouter(); 
 
    routerService.save(router);

    return new ResponseEntity<>(routerDto, HttpStatus.OK);
  }

  @DeleteMapping("/{routerId}")
  public ResponseEntity<String> delete(@PathVariable Long routerId){
    Router router = routerService.findById(routerId);

    if(router == null){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }  

    routerService.delete(router);

    return new ResponseEntity<>("Deleted router id - " + routerId, HttpStatus.OK);
  }
}
