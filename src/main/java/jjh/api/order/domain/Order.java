package jjh.api.order.domain;

import jjh.api.item.domain.Item;
import jjh.api.user.domain.User;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Orders")
public class Order {
    @Id @Column(name = "order_id")
    private long orderId;

    @Column(name = "price")
    private long price;

    @Column(name = "order_status")
    private String count;

    //FetchType.LAZY user, item 선행 일 때 사용 가능. (끌어옴)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    //item == mappedBy
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

}
