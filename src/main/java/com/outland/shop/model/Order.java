package com.outland.shop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.outland.shop.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Orders")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<OrderItem> orderItems;

    @Enumerated(EnumType.STRING)
    @Column(length = 12, columnDefinition = "VARCHAR(12) DEFAULT 'PROCESSING'")
    private OrderStatus orderStatus;

    @Transient
    public Integer getNumberOfProducts() {
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

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Order order = (Order) o;
        return getId() != null && Objects.equals(getId(), order.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
