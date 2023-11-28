package com.fastcampus.reserve.restdocs.order.mock;

import com.fastcampus.reserve.domain.product.Product;
import com.fastcampus.reserve.domain.product.ProductImage;
import com.fastcampus.reserve.domain.product.ProductReader;
import java.time.LocalDate;
import java.util.List;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.test.util.ReflectionTestUtils;

@Primary
@Component
public class FakeProductReader implements ProductReader {

    @Override
    public Product getProduct(Long id) {
        return null;
    }

    @Override
    public List<Product> getAllProduct(LocalDate checkIn,
                                       LocalDate checkOut,
                                       String category,
                                       String areaCode,
                                       int page,
                                       int pageSize) {
        return null;
    }

    @Override
    public Product findByIdWithImage(Long id) {
        ProductImage productImage = ProductImage.builder()
                .url("https://www.image.co.kr")
                .build();

        Product product = Product.builder()
                .name("name")
                .category("hotel")
                .description("description")
                .zipCode("zipcode")
                .address("address")
                .longitude("longitude")
                .latitude("latitude")
                .area("area")
                .sigungu("sigungu")
                .build();

        product.addImage(productImage);

        ReflectionTestUtils.setField(product, "id", -1L);

        return product;
    }
}