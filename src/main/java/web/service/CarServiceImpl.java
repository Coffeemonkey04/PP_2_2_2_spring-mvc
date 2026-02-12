package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{

    private final List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(1L, "car1", 1111));
        cars.add(new Car(2L, "car2", 2222));
        cars.add(new Car(3L, "car3", 3333));
        cars.add(new Car(4L, "car4", 4444));
        cars.add(new Car(5L, "car5", 5555));
    }

    @Override
    public List<Car> getCars(Integer count) {
        long limit = count == null || count < 0 ? 0 :
                Math.min(count, cars.size());

        return cars.stream()
                .limit(limit)
                .collect(Collectors.toList());
    }
}
