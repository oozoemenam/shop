package com.outland.shop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.outland.shop.enums.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    @Enumerated(EnumType.STRING)
    @Column(length = 12, columnDefinition = "VARCHAR(12) DEFAULT 'PROCESSING'")
    private OrderStatus orderStatus;

    @Transient
    public int getNumberOfProducts() {
        return getOrderItems().size();
    }

    @Transient
    public Double getTotalOrderPrice() {
        double sum = 0D;
        List<OrderItem> orderItems = getOrderItems();
        for (OrderItem orderItem : orderItems) {
            sum += orderItem.getTotalPrice();
        }
        return sum;
    }

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDate createAt;
}
