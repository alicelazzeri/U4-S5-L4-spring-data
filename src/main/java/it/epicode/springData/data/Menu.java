package it.epicode.springData.data;

import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "menus")
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "menu")
    @Autowired
    private List<Pizza> pizzaList;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "menu")
    @Autowired
    private List<Drink> drinkList;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "menu")
    @Autowired
    private List<Topping> toppingList;

    public Menu(String name) {
        this.name = name;
    }

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
