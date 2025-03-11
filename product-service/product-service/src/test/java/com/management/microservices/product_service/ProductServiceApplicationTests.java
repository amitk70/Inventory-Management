package com.management.microservices.product_service;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;


@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	@ServiceConnection
	private static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

	@LocalServerPort
	private Integer port;

	void setup(){
		RestAssured.baseURI = "http://localhost:27017";
		RestAssured.port = port;
	}

	static {
		mongoDBContainer.start();
	}

//	@Autowired
//	ProductService productService;
//
//	@Autowired
//	ProductRepository productRepository;




	@Test
	void createProduct() {

//		Product product = Product.builder().name("amit").description("d").price(BigDecimal.valueOf(1232)).build();
//		productRepository.save(product);
//		System.out.println(product);
//		Assertions.assertTrue(!product.getId().isEmpty());

		String requestBody = """
				{
				        "name": "Samsung",
				        "description": "Smartphone",
				        "price": "213213"
				}
				""";
		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.post("api/product/create")
				.then()
				.statusCode(201)
				.body("id", Matchers.notNullValue())
				.body("name",Matchers.equalTo("Samsung"))
				.body("description",Matchers.equalTo("Smartphone"))
				.body("price",Matchers.equalTo(213213));


	}



}
