package com.fastcampus.reserve.domain.order.orderitem;

import com.fastcampus.reserve.domain.BaseTimeEntity;
import com.fastcampus.reserve.domain.order.Order;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class OrderItem extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private Long roomId;

    @Column(nullable = false)
    private Integer guestCount;

    @Column(nullable = false)
    private Integer price;

    private Long cartId;
    private LocalDate checkInDate;
    private LocalTime checkInTime;
    private LocalDate checkOutDate;
    private LocalTime checkOutTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Builder
    private OrderItem(
            Long productId,
            Long roomId,
            Integer guestCount,
            Integer price,
            Long cartId,
            LocalDate checkInDate,
            LocalTime checkInTime,
            LocalDate checkOutDate,
            LocalTime checkOutTime
    ) {
        this.productId = productId;
        this.roomId = roomId;
        this.guestCount = guestCount;
        this.price = price;
        this.cartId = cartId;
        this.checkInDate = checkInDate;
        this.checkInTime = checkInTime;
        this.checkOutDate = checkOutDate;
        this.checkOutTime = checkOutTime;
    }

    public void registerOrder(Order order) {
        if (!Objects.isNull(this.order)) {
            this.order.getOrderItems().remove(this);
        }

        this.order = order;
        order.addOrderItem(this);
    }
}
