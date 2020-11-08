package br.com.redis;

import br.com.redis.model.Redis;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SpringBootTest
class AppConfigTests {

	@Test
	void getAllInformation() {
		RequestSpecification request = RestAssured.given();
		// Setting Base URI
		request.baseUri("https://localhost:8080");
		// Setting Base Path
		request.basePath("/");

		Response response = request.get();

		System.out.println(response.asString());

		JsonPath path = given()
				.header("Accept", "application/json")
				.get("/gradle-redis")
				.andReturn().jsonPath();

		Redis redis1 = path.getObject("list[0]", Redis.class);

		Redis result = new Redis();
		result.setIdentifier("1010");
		result.setName("Job 1010");

		assertEquals(result, redis1);
	}

	@Test
	void addInformation() {

		Redis redis = new Redis();
		redis.setIdentifier("1010");
		redis.setName("Company 10102");

		JsonPath result =
				given()
						.header("Accept", "application/json")
						.contentType("application/json")
						.body(redis)
						.expect()
						.statusCode(200)
						.when()
						.post("/gradle-redis")
						.andReturn()
						.jsonPath();

		Redis response = result.getObject("", Redis.class);

		assertEquals("Job 1010", response.getName());
		assertEquals("1010", response.getIdentifier());
	}
}
