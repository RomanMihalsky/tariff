package com.faustov.tariff.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faustov.tariff.entity.Tariff;

public interface TariffRepository extends JpaRepository<Tariff, Long>{

}
