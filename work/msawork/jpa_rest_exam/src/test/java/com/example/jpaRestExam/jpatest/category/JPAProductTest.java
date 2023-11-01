package com.example.jpaRestExam.jpatest.category;

import com.example.jpaRestExam.product.model.Category;
import com.example.jpaRestExam.product.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@Transactional
class JPAProductTest {

    @PersistenceContext
    EntityManager em;

    @Test
    @Rollback(value = false)
    void entityTest() {
        Category category1 = new Category("전자", "컴퓨터, 티비");
        Category category2 = new Category("식품", "맛있는 카레");
        Category category3 = new Category("잡화", "마요네즈 사야하는데");

        em.persist(category1);
        em.persist(category2);
        em.persist(category3);

        Product productEntity1 = new Product("휴대폰", "샘숭",10000, "1000", category1);
        Product productEntity2 = new Product("휴대폰", "애플",10000, "1200", category1);
        Product productEntity3 = new Product("마요네즈", "오뚜기",10000, "3600", category2);
        Product productEntity4 = new Product("양상추", "농협",10000, "3600", category2);
        Product productEntity5 = new Product("빨래 바구니", "도 오늘 사야겠다",10000, "3600", category3);

        em.persist(productEntity1);
        em.persist(productEntity2);
        em.persist(productEntity3);
        em.persist(productEntity4);
        em.persist(productEntity5);

//        em.flush();
//        em.clear();
//
//        List<ProductEntity> list = em.createQuery("select p from Product p", ProductEntity.class)
//                .getResultList();
//
//        for (ProductEntity productEntity : list) {
//            System.out.println("productEntity.toString() = " + productEntity.toString());
//        }
//    }
//
//    @Test
//    @Rollback(value = false)
//    void joinTest() {
//        CategoryEntity categoryEntity = em.find(CategoryEntity.class, 1L);
//        List<ProductEntity> productList = categoryEntity.getProductList();
//
//        for (ProductEntity productEntity : productList) {
//            System.out.println("productEntity.toString() = " + productEntity.toString());
//        }
//    }
//
//    @Test
//    @Rollback(value = false)
//    void test() {
//        Category category1 = new Category("주방가구", "식탁과 수납장");
//        Category category2 = new Category("거실가구", "쇼파와 수납장");
//        Category category3 = new Category("침구", "침대와 협탁");
//
//        em.persist(category1);
//        em.persist(category2);
//        em.persist(category3);
    }
}