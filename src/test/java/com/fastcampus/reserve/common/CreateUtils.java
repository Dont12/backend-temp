package com.fastcampus.reserve.common;

import com.fastcampus.reserve.domain.order.Order;
import com.fastcampus.reserve.domain.order.RegisterOrder;
import com.fastcampus.reserve.domain.order.orderitem.OrderItem;
import com.fastcampus.reserve.domain.order.payment.Payment;
import com.fastcampus.reserve.domain.user.User;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public final class CreateUtils {

    private CreateUtils() {
    }

    public static User createUser() {
        return User.builder()
                .email("user@gmail.com")
                .password("password")
                .nickname("name")
                .phone("010-0000-0000")
                .build();
    }

    public static Order createOrder() {
        return Order.builder()
                .payment(Payment.CARD)
                .userName("userName")
                .userPhone("010-0000-0000")
                .build();
    }

    public static RegisterOrder createRegisterOrder() {
        return RegisterOrder.builder()
                .userId(-1L)
                .name("name")
                .phone("010-0000-0000")
                .orderItems(createOrderItems())
                .build();
    }

    public static List<OrderItem> createOrderItems() {
        return List.of(OrderItem.builder()
                .productId(-1L)
                .roomId(-1L)
                .guestCount(2)
                .price(139000)
                .checkInDate(LocalDate.now())
                .checkInTime(LocalTime.of(15, 0))
                .checkOutDate(LocalDate.now().plusDays(1))
                .checkOutTime(LocalTime.of(12, 0))
                .build());
    }
}