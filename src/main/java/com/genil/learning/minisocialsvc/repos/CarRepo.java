package com.genil.learning.minisocialsvc.repos;

import com.genil.learning.minisocialsvc.data.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Antony Genil on 12/18/19 at 16 27 for mini-social-svc
 **/
public interface CarRepo extends JpaRepository<Car, Long> {

    List<Car> findAll();
    List<Car> findByName(String name);
    List<Car> findByCarType(String carType);

}
