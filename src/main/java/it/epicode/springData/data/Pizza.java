package it.epicode.springData.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@DiscriminatorValue("Pizza")
@NoArgsConstructor
public class Pizza extends Item {
    private String name;
    @ManyToMany
    @JoinTable(name = "toppings_pizzas", joinColumns = @JoinColumn(name = "pizzas"), inverseJoinColumns = @JoinColumn(name = "toppings"))
    private List<Topping> toppingList;
    private boolean isXl = false;

    public Pizza(String name, List<Topping> toppingList, boolean isXl) {
        super(700, 4.3);
        this.name = name;
        this.toppingList = toppingList;
        this.isXl = isXl;
    }

    @Override
    public int getCalories() {
        return super.getCalories() + this.getToppingList().stream().mapToInt(Topping::getCalories).sum();
    }

    @Override
    public double getPrice() {
        return super.getPrice() + this.getToppingList().stream().mapToDouble(Topping::getPrice).sum();
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", price=" + price +
                ", isXl=" + isXl +
                '}';
    }
}
