package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarServiceImpl carService;

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
        car.setCarId("C001");
        car.setCarName("Toyota Avanza");
        car.setCarColor("Black");
        car.setCarQuantity(5);
    }

    @Test
    void testCreateCar() {
        Car result = carService.create(car);

        verify(carRepository, times(1)).createCar(car);
        assertEquals(car, result);
    }

    @Test
    void testFindAll() {
        List<Car> carList = Arrays.asList(car);
        Iterator<Car> iterator = carList.iterator();

        when(carRepository.findAll()).thenReturn(iterator);

        List<Car> result = carService.findAll();

        assertEquals(1, result.size());
        assertEquals("C001", result.get(0).getCarId());

        verify(carRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        when(carRepository.findById("C001")).thenReturn(car);

        Car result = carService.findById("C001");

        assertNotNull(result);
        assertEquals("Toyota Avanza", result.getCarName());

        verify(carRepository, times(1)).findById("C001");
    }

    @Test
    void testUpdate() {
        carService.update("C001", car);

        verify(carRepository, times(1)).update("C001", car);
    }

    @Test
    void testDeleteCarById() {
        carService.deleteCarById("C001");

        verify(carRepository, times(1)).delete("C001");
    }
}