package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car();
        this.car.setCarId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        this.car.setCarName("Sedan Cap Bambang");
        this.car.setCarColor("Ungu");
        this.car.setCarQuantity(1);
    }

    @Test
    void testGetCarId() {
        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", car.getCarId());
    }

    @Test
    void testGetCarName() {
        assertEquals("Sedan Cap Bambang", car.getCarName());
    }

    @Test
    void testGetCarColor() {
        assertEquals("Ungu", car.getCarColor());
    }

    @Test
    void testGetCarQuantity() {
        assertEquals(1, car.getCarQuantity());
    }
}
