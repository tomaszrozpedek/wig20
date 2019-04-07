package com.tomaszr.wig20.model.repositories;

import com.tomaszr.wig20.model.entities.Intraday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface IntradayRepository extends Repository<Intraday, Long> {
    List<Intraday> findByName(String name);
}
