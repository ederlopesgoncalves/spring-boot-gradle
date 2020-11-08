package br.com.redis.controller;

import br.com.redis.model.Redis;
import br.com.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gradle-redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping
    public List<Redis> findAll() {
        return redisService.findAll();
    }

    @GetMapping("/{identifier}")
    public Redis findByIdentifier(@PathVariable("identifier") final String identifier) {
        return redisService.findbyIdentifier(identifier);
    }

    @PostMapping
    public Redis create(@RequestBody final Redis redis) {
        return redisService.create(redis);
    }

    @PutMapping
    public Redis update(@RequestBody final Redis redis) {
        return redisService.update(redis);
    }

    @DeleteMapping("/{identifier}")
    public void delete(@PathVariable("identifier") final String identifier) {
        redisService.delete(identifier);
    }

}
