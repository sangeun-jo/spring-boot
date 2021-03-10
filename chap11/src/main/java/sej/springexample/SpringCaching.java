package sej.springexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@EnableCaching
@SpringBootApplication
public class SpringCaching implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(SpringCaching.class);

    @Autowired
    NonDbRepository nonDbRepository;

    public static void main(String arg[]) {
        SpringApplication.run(SpringCaching.class, arg);
    }

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        Cache myCache = new ConcurrentMapCache("carName");
        cacheManager.setCaches(Arrays.asList(myCache));
        return cacheManager;
    }

    @Override
    public void run(String... arg) throws Exception {
        logger.info("자동차 정보");

        logger.info("no1::" + nonDbRepository.getByName("스팅어"));
        logger.info("no2::" + nonDbRepository.getByName("k5"));
        logger.info("no3::" + nonDbRepository.getByName("BMW"));
        logger.info("no4::" + nonDbRepository.getByName("벤츠"));
        logger.info("no5::" + nonDbRepository.getByName("페라리"));

        logger.info("no1::" + nonDbRepository.getByName("스팅어"));
        logger.info("no2::" + nonDbRepository.getByName("k5"));


        //cache manager 로 출력
        logger.info("cacheManager::" + nonDbRepository.getByNameWithCacheManager("스팅어"));
        logger.info("cacheManager::" + nonDbRepository.getByNameWithCacheManager("스팅어"));
        logger.info("cacheManager::" + nonDbRepository.getByNameWithCacheManager("k5"));
    }
}
