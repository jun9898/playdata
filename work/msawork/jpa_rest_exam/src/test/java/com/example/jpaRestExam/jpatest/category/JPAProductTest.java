package com.example.jpaRestExam.jpatest.category;

import com.example.jpaRestExam.product.model.Category;
import com.example.jpaRestExam.product.model.Order;
import com.example.jpaRestExam.product.model.OrderProduct;
import com.example.jpaRestExam.product.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

        Product productEntity1 = new Product("자기전에 듣는 김영한 구현동화", "잠이 솔솔와요",10000, "https://infcon.day/wp-content/uploads/2017/02/%E1%84%80%E1%85%B5%E1%86%B7%E1%84%8B%E1%85%A7%E1%86%BC%E1%84%92%E1%85%A1%E1%86%AB.jpg", category1);
        Product productEntity2 = new Product("자기전에 듣는 김영한 구현동화", "잠이 솔솔와요",10000, "https://infcon.day/wp-content/uploads/2017/02/%E1%84%80%E1%85%B5%E1%86%B7%E1%84%8B%E1%85%A7%E1%86%BC%E1%84%92%E1%85%A1%E1%86%AB.jpg", category1);
        Product productEntity3 = new Product("자기전에 듣는 김영한 구현동화", "잠이 솔솔와요",10000, "https://infcon.day/wp-content/uploads/2017/02/%E1%84%80%E1%85%B5%E1%86%B7%E1%84%8B%E1%85%A7%E1%86%BC%E1%84%92%E1%85%A1%E1%86%AB.jpg", category1);
        Product productEntity4 = new Product("자기전에 듣는 김영한 구현동화", "잠이 솔솔와요",10000, "https://infcon.day/wp-content/uploads/2017/02/%E1%84%80%E1%85%B5%E1%86%B7%E1%84%8B%E1%85%A7%E1%86%BC%E1%84%92%E1%85%A1%E1%86%AB.jpg", category1);
        Product productEntity5 = new Product("자기전에 듣는 김영한 구현동화", "잠이 솔솔와요",10000, "https://infcon.day/wp-content/uploads/2017/02/%E1%84%80%E1%85%B5%E1%86%B7%E1%84%8B%E1%85%A7%E1%86%BC%E1%84%92%E1%85%A1%E1%86%AB.jpg", category1);

        em.persist(productEntity1);
        em.persist(productEntity2);
        em.persist(productEntity3);
        em.persist(productEntity4);
        em.persist(productEntity5);

//        List<ProductEntity> list = em.createQuery("select p from Product p", ProductEntity.class)
//                .getResultList();
//
//        for (ProductEntity productEntity : list) {
//            System.out.println("productEntity.toString() = " + productEntity.toString());
//        }
    }

    @Test
    @Rollback(value = false)
    @Disabled
    void joinTest() {
/*
        CategoryEntity categoryEntity = em.find(CategoryEntity.class, 1L);
        List<ProductEntity> productList = categoryEntity.getProductList();

        for (ProductEntity productEntity : productList) {
            System.out.println("productEntity.toString() = " + productEntity.toString());
        }
*/
    }

    @Test
    @Rollback(value = false)
    @Disabled
    void test() {
        Category category1 = new Category("주방가구", "식탁과 수납장");
        Category category2 = new Category("거실가구", "쇼파와 수납장");
        Category category3 = new Category("침구", "침대와 협탁");

        em.persist(category1);
        em.persist(category2);
        em.persist(category3);
    }

    @Test
    @Rollback(value = false)
    void test2() {
        Product product = em.find(Product.class, 1L);
        OrderProduct orderProduct = new OrderProduct(3000,5, product);
        OrderProduct orderProduct1 = new OrderProduct(3000,5, product);
        OrderProduct orderProduct2 = new OrderProduct(3000,5, product);
        OrderProduct orderProduct3 = new OrderProduct(3000,5, product);
        OrderProduct orderProduct4 = new OrderProduct(3000,5, product);
        em.persist(orderProduct);
        em.persist(orderProduct1);
        em.persist(orderProduct2);
        em.persist(orderProduct3);
        em.persist(orderProduct4);
    }

    @Test
    @Rollback(value = false)
    void orderTest() {
        List<OrderProduct> orderProductList = new ArrayList<>();
        OrderProduct orderProduct2 = em.find(OrderProduct.class, 2L);
        OrderProduct orderProduct3 = em.find(OrderProduct.class, 3L);
        OrderProduct orderProduct4 = em.find(OrderProduct.class, 4L);
        OrderProduct orderProduct5 = em.find(OrderProduct.class, 5L);
        OrderProduct orderProduct6 = em.find(OrderProduct.class, 1L);

        System.out.println("orderProduct2 = " + orderProduct2.toString());

        orderProductList.add(orderProduct2);
        orderProductList.add(orderProduct3);
        orderProductList.add(orderProduct4);
        orderProductList.add(orderProduct5);
        orderProductList.add(orderProduct6);

        Order order = Order.buildOrderEntity("독산동", orderProductList);

        System.out.println(order.toString());

        em.persist(order);



    }

}