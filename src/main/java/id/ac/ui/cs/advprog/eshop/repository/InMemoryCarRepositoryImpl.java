package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.exception.CarNotFoundException;
import id.ac.ui.cs.advprog.eshop.model.Car;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class InMemoryCarRepositoryImpl implements CarRepository {
    private final List<Car> carData = new ArrayList<>();

    @Override
    public Car createCar(Car car) {
        setCarId(car);
        carData.add(car);
        return car;
    }

    private void setCarId(Car car) {
        if (car.getCarId() == null) {
            UUID uuid = UUID.randomUUID();
            car.setCarId(uuid.toString());
        }
    }

    @Override
    public Iterator<Car> findAll() {
        return carData.iterator();
    }

    @Override
    public Car findById(String id) {
        return carData.stream()
                .filter(car -> car.getCarId().equals(id))
                .findFirst()
                .orElseThrow(() -> new CarNotFoundException(id));
    }

    @Override
    public Car update(String id, Car updatedCar) {
        Car car = findById(id);
        car.setCarName(updatedCar.getCarName());
        car.setCarColor(updatedCar.getCarColor());
        car.setCarQuantity(updatedCar.getCarQuantity());
        return car;
    }

    @Override
    public void delete(String id) {
        boolean removed = carData.removeIf(car -> car.getCarId().equals(id));
        if (!removed) {
            throw new CarNotFoundException(id);
        }
    }
}
