package it.epicode.springData.repositories;

import it.epicode.springData.data.Drink;
import it.epicode.springData.data.Item;
import it.epicode.springData.data.Pizza;
import it.epicode.springData.data.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT p FROM Pizza p" )
    List<Pizza> findPizza();

    @Query ("SELECT t from Topping t")
    List<Topping> findTopping();

    @Query ("SELECT d FROM Drink d" )
    List<Drink> findDrink();
}
