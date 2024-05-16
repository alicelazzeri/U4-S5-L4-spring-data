package it.epicode.springData.data;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pizzas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")

public class Pizza extends Item {
    @Column
    private String name;
    @Column
    private boolean isXl = false;

    @OneToMany(mappedBy = "pizza", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Topping> toppings = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @Override
    public int getCalories() {
        return super.getCalories() + this.toppings.stream().mapToInt(Topping::getCalories).sum();
    }

    @Override
    public double getPrice() {
        return super.getPrice() + this.toppings.stream().mapToDouble(Topping::getPrice).sum();
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", calories=" + getCalories() +
                ", price=" + getPrice() +
                ", toppings=" + toppings +
                ", isXl=" + isXl +
                '}';
    }
}
