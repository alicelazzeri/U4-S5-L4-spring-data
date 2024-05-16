package it.epicode.springData.data;

import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "item_type")
@Table(name = "items")
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected int calories;
    protected double price;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    protected Menu menu;
    @ManyToMany(mappedBy = "orderedProducts")
    private List<Order> orders;

    public Item(int calories, double price) {
        this.calories = calories;
        this.price = price;
    }
}
