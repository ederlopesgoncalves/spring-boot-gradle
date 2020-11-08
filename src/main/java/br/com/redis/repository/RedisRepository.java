package br.com.redis.repository;

import br.com.redis.model.Redis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RedisRepository extends JpaRepository<Redis, String> {
}
