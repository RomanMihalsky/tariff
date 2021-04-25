package com.faustov.tariff.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faustov.tariff.entity.Status;
import com.faustov.tariff.entity.Tariff;
import com.faustov.tariff.exception.TariffNotFoundException;
import com.faustov.tariff.repository.TariffRepository;

@Service
public class TariffService {
  
  private TariffRepository tariffRepository;
  
  @Autowired
  public TariffService(TariffRepository tariffRepository) {
    this.tariffRepository = tariffRepository;
  }

  public List<Tariff> getAll() {
    List<Tariff> result = tariffRepository.findAll();
    return result;
  }

  public Tariff save(Tariff tariff) {
    tariff.setStatus(Status.ACTIVE);
    tariff.setCreated(LocalDate.now());
    tariff.setUpdated(LocalDate.now());
    return tariffRepository.save(tariff);
  }

  public Tariff update(Tariff tariff) {
    tariff.setUpdated(LocalDate.now());
    return tariffRepository.save(tariff);
  }

  public void delete(Tariff tariff) {
    tariffRepository.delete(tariff);
  }

  public Tariff findById(Long id) {
    return tariffRepository.findById(id)
        .orElseThrow(() -> new TariffNotFoundException("Tariff by id: " + id + " was not found"));
  }
}

