package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import org.springframework.stereotype.Repository;
import java.util.Iterator;

@Repository
public interface CarRepository {
    public Car createCar(Car car);
    public Iterator<Car> findAll();
    public Car findById(String id);
    public Car update(String id, Car updatedCar);
    public void delete(String id);
}
