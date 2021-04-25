package com.faustov.tariff.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faustov.tariff.entity.Router;
import com.faustov.tariff.entity.Status;
import com.faustov.tariff.entity.Tariff;
import com.faustov.tariff.exception.TariffNotFoundException;
import com.faustov.tariff.repository.RouterRepository;
import com.faustov.tariff.repository.TariffRepository;

@Service
public class RouterService {
  
  private RouterRepository routerRepository;
  
  @Autowired
  public RouterService(RouterRepository routerRepository) {
    this.routerRepository = routerRepository;
  }

  public List<Router> getAll() {
    List<Router> result = routerRepository.findAll();
    return result;
  }

  public Router save(Router router) {
    router.setStatus(Status.ACTIVE);
    router.setCreated(LocalDate.now());
    router.setUpdated(LocalDate.now());
    return routerRepository.save(router);
  }

  public Router update(Router router) {
    router.setUpdated(LocalDate.now());
    return routerRepository.save(router);
  }

  public void delete(Router router) {
    routerRepository.delete(router);
  }

  public Router findById(Long id) {
    return routerRepository.findById(id)
        .orElseThrow(() -> new TariffNotFoundException("Tariff by id: " + id + " was not found"));
  }
}

