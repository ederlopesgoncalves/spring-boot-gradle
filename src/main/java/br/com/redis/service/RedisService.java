package br.com.redis.service;

import br.com.redis.controller.exceptions.EntityNotFoundException;
import br.com.redis.model.Redis;
import br.com.redis.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisService {

    @Autowired
    private RedisRepository redisRepository;

    @Cacheable(cacheNames = Redis.CACHE_NAME, key="#root.method.name")
    public List<Redis> findAll() {
        return redisRepository.findAll();
    }

    @Cacheable(cacheNames = Redis.CACHE_NAME, key="#identifier")
    public Redis findbyIdentifier(final String identifier) {
        return redisRepository.findById(identifier)
                .orElseThrow(() -> new EntityNotFoundException("Identifier not found: " + identifier));
    }

    @CacheEvict(cacheNames = Redis.CACHE_NAME, allEntries = true)
    public Redis create(final Redis redis) {
        return redisRepository.save(redis);
    }

    @CachePut(cacheNames = Redis.CACHE_NAME, key="#redis.getIdentifier()")
    public Redis update(final Redis redis) {
        if(redis.getIdentifier() == null) {
            throw new EntityNotFoundException("Identifier is empty");
        }
        return redisRepository.save(redis);
    }

    @CacheEvict(cacheNames = Redis.CACHE_NAME, key="#identifier")
    public void delete(final String identifier) {
        if(identifier == null) {
            throw new EntityNotFoundException("Identifier is empty");
        }
        redisRepository.deleteById(identifier);
    }
}
