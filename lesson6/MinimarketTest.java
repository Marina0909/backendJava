package org.example.lesson6;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.db.dao.ProductsMapper;
import org.example.db.model.Products;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MinimarketTest  {
    static Integer id;
    @BeforeAll
    static public void before() {

        baseURI = "https://minimarket1.herokuapp.com/market";
        requestSpecification = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .build();
        responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectResponseTime(Matchers.lessThan(3000L))
                .build();
        }
    @DisplayName("Добавление продукта")
    @Order(1)
    @Test
    void addProductMinimarketTest(){

        id = given()
                .contentType("application/json")
                .body("{ \"id\": null, \"title\": \"Pizza_Italian\", \"price\": 170, \"categoryTitle\": \"Food\"}")
                .when()
                .post("/api/v1/products")
                .prettyPeek()
                .then()
                .statusCode(201)
                .extract()
                .jsonPath()
                .get("id");
    }
    @DisplayName("Поиск продукта")
    @Order(2)
    @Test
    void readProductMinimarketTest() throws IOException {
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("myBatisConfig.xml"));
        try (SqlSession session = sessionFactory.openSession()) {
            ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
            Products product = productsMapper.selectByPrimaryKey((long) id);

            assertThat(product.getTitle().equals("Pizza_Italian")).isTrue();
            assertThat(product.getPrice().equals(170)).isTrue();
            assertThat(product.getId().equals((long) id)).isTrue();
        }
    }

    @DisplayName("Удаление продукта")
    @Order(3)
    @Test
    void deleteProductMinimarketTest() throws IOException {
        SqlSessionFactory sessionFactoryD = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("myBatisConfig.xml"));
        try (SqlSession session = sessionFactoryD.openSession()) {
            ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
            productsMapper.deleteByPrimaryKey((long) id);
            session.commit();
        }
    }

    @DisplayName("Проверка удаления продукта")
    @Order(4)
    @Test
    void checkDelProductMinimarketTest() {
        given()
                .contentType("application/json")
                .when()
                .get("/api/v1/products/" + id)
                .prettyPeek()
                .then()
                .statusCode(404);

    }
}
