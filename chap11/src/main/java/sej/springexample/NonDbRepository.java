package sej.springexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NonDbRepository {
    private final long sleepTime = 3000L;
    private final Logger logger =LoggerFactory.getLogger(NonDbRepository.class);

    @Autowired
    private CacheManager cacheManager;

    public Car getByNameWithCacheManager(String name) {
        Cache cache = cacheManager.getCache("carName");
        return randomCarColor(cache.get(name, Car.class));
    }

    //@Cacheable(cacheNames = "carName", key = "#name") //캐시 적용할 메서드
    @Cacheable(cacheNames = "carName")
    public Car getByName(String name) {
        makeSlowService();
        Car myCar = new Car(name);
        return randomCarColor(myCar);
    }


    private Car randomCarColor(Car car) {
        Random rn = new Random();
        rn.setSeed(System.currentTimeMillis());

        String colors[] = {"red", "blue", "gray", "white", "purple"};
        for (int i=0; i<5; i++) {
            int b = rn.nextInt(5);
            car.setColor(colors[b]);
        }

        return car;
    }

    private void makeSlowService() {
        logger.info("start sleep");
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException ire){
            throw new IllegalStateException(ire);
        }
        logger.info("end sleep");
    }
}
