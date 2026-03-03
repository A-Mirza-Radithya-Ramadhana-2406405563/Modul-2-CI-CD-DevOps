package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.exception.CarNotFoundException;
import id.ac.ui.cs.advprog.eshop.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class CarRepositoryTest {
    private InMemoryCarRepository carRepository;

    @BeforeEach
    void setUp() {
        carRepository = new InMemoryCarRepository();
    }

    @Test
    void testCreateAndFind() {
        Car car = new Car();
        car.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car.setCarName("Sedan Cap Bambang");
        car.setCarColor("ungu");
        car.setCarQuantity(1);
        carRepository.createCar(car);

        Iterator<Car> carIterator = carRepository.findAll();
        assertTrue(carIterator.hasNext());
        Car savedcar = carIterator.next();
        assertEquals(car.getCarId(), savedcar.getCarId());
        assertEquals(car.getCarName(), savedcar.getCarName());
        assertEquals(car.getCarColor(), savedcar.getCarColor());
        assertEquals(car.getCarQuantity(), savedcar.getCarQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Car> carIterator = carRepository.findAll();
        assertFalse(carIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneCar() {
        Car car1 = new Car();
        car1.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car1.setCarName("Sedan Cap Bambang");
        car1.setCarColor("ungu");
        car1.setCarQuantity(1);
        carRepository.createCar(car1);

        Car car2 = new Car();
        car2.setCarId("a0f9de46-90b1-437d-a0bf-d0821dde9906");
        car2.setCarName("Sedan Cap Usep");
        car2.setCarColor("merah");
        car2.setCarQuantity(5);
        carRepository.createCar(car2);

        Iterator<Car> carIterator = carRepository.findAll();
        assertTrue(carIterator.hasNext());
        Car savedCar = carIterator.next();
        assertEquals(car1.getCarId(), savedCar.getCarId());
        savedCar = carIterator.next();
        assertEquals(car2.getCarId(), savedCar.getCarId());
        assertFalse(carIterator.hasNext());
    }

    @Test
    void testFindByIdIfCarExists() {
        Car car = new Car();
        car.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car.setCarName("Sedan Cap Bambang");
        car.setCarColor("ungu");
        car.setCarQuantity(100);
        carRepository.createCar(car);

        Car savedCar = carRepository.findById(car.getCarId());
        assertEquals(car, savedCar);
    }

    @Test
    void testFindByIdIfCarDoesNotExist() {
        assertThrows(CarNotFoundException.class, () -> {
            carRepository.findById("NO_ID");
        });
    }

    @Test
    void testUpdateCarIfCarExists() {
        Car car = new Car();
        car.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car.setCarName("Sedan Cap Bambang");
        car.setCarColor("ungu");
        car.setCarQuantity(100);
        carRepository.createCar(car);

        Car editedCar = new Car();
        editedCar.setCarName("Sedan Cap");
        editedCar.setCarColor("merah");
        editedCar.setCarQuantity(50);
        carRepository.update(car.getCarId(), editedCar);

        Car savedCar = carRepository.findById(car.getCarId());
        assertEquals("Sedan Cap", savedCar.getCarName());
        assertEquals(50, savedCar.getCarQuantity());
        assertEquals("merah", savedCar.getCarColor());
    }

    @Test
    void testEditCarIfCarDoesNotExist() {
        Car editedCar = new Car();
        editedCar.setCarName("Sedan Cap");
        editedCar.setCarQuantity(50);
        assertThrows(CarNotFoundException.class, () -> {
            carRepository.update("NO_ID", editedCar);
        });
    }

    @Test
    void testDeleteCarIfCarExists() {
        Car car = new Car();
        car.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        car.setCarName("Sampo Cap Bambang");
        car.setCarQuantity(100);
        carRepository.createCar(car);
        assertEquals(car, carRepository.findById(car.getCarId()));
        carRepository.delete(car.getCarId());
        String id = car.getCarId();
        assertThrows(CarNotFoundException.class, () -> {
            carRepository.findById("NO_ID");
        });
    }
}
