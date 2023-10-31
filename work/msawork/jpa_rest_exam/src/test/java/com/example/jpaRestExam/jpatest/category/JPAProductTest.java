package com.example.jpaRestExam.jpatest.category;

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
        CategoryEntity category1 = new CategoryEntity("전자", "컴퓨터, 티비");
        CategoryEntity category2 = new CategoryEntity("식품", "맛있는 카레");
        CategoryEntity category3 = new CategoryEntity("잡화", "마요네즈 사야하는데");

        em.persist(category1);
        em.persist(category2);
        em.persist(category3);

        ProductEntity productEntity1 = new ProductEntity("휴대폰", "샘숭", "1000", category1);
        ProductEntity productEntity2 = new ProductEntity("휴대폰", "애플", "1200", category1);
        ProductEntity productEntity3 = new ProductEntity("마요네즈", "오뚜기", "3600", category2);
        ProductEntity productEntity4 = new ProductEntity("양상추", "농협", "3600", category2);
        ProductEntity productEntity5 = new ProductEntity("빨래 바구니", "도 오늘 사야겠다", "3600", category3);

        em.persist(productEntity1);
        em.persist(productEntity2);
        em.persist(productEntity3);
        em.persist(productEntity4);
        em.persist(productEntity5);

        em.flush();
        em.clear();

        List<ProductEntity> list = em.createQuery("select p from ProductEntity p", ProductEntity.class)
                .getResultList();

        for (ProductEntity productEntity : list) {
            System.out.println("productEntity.toString() = " + productEntity.toString());
        }
    }

    @Test
    @Rollback(value = false)
    void joinTest() {
        CategoryEntity categoryEntity = em.find(CategoryEntity.class, 1L);
        List<ProductEntity> productList = categoryEntity.getProductList();

        for (ProductEntity productEntity : productList) {
            System.out.println("productEntity.toString() = " + productEntity.toString());
        }
    }
}