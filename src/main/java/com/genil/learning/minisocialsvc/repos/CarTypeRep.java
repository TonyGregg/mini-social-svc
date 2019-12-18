package com.genil.learning.minisocialsvc.repos;

import com.genil.learning.minisocialsvc.data.CarType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Antony Genil on 12/18/19 at 16 05 for mini-social-svc
 **/
public interface CarTypeRep extends JpaRepository<CarType, Long> {
    List<CarType> findAll();
    List<CarType> findAll(Sort sort);
    CarType save(CarType carType);

}
