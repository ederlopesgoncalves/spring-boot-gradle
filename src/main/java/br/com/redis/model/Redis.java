package br.com.redis.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Redis implements Serializable {

    public static final String CACHE_NAME = "Redis";

    @Id
    private String identifier;
    private String name;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Redis redis = (Redis) o;
        return Objects.equals(identifier, redis.identifier) &&
                Objects.equals(name, redis.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, name);
    }
}
