package it.epicode.springData.data;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table (name = "menu")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component

public class Menu {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    @OneToMany (mappedBy = "menu")
    private List<Pizza> pizzaList;

    @OneToMany (mappedBy = "menu")
    private List<Drink> drinkList;

    @OneToMany (mappedBy = "menu")
    private List<Topping> toppingList;

    public void printMenu() {
        System.out.println("******* Menu *******");
        System.out.println("PIZZAS");
        this.pizzaList.forEach(System.out::println);
        System.out.println();

        System.out.println("TOPPINGS");
        this.toppingList.forEach(System.out::println);
        System.out.println();

        System.out.println("DRINKS");
        this.drinkList.forEach(System.out::println);
        System.out.println();

    }
}

