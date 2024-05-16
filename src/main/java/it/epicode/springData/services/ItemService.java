package it.epicode.springData.services;

import it.epicode.springData.data.Drink;
import it.epicode.springData.data.Item;
import it.epicode.springData.data.Pizza;
import it.epicode.springData.data.Topping;
import it.epicode.springData.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    public Item findItemById(long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public void deleteItem(long id) {
//        var item = this.findMenuById(id);
//        itemRepository.deleteItem(item);
        itemRepository.deleteById(id);
    }

    public List<Pizza> getPizza () {
        return itemRepository.findPizza();
    }

    public List<Topping> getTopping() {
        return itemRepository.findTopping();
    }

    public List<Drink> getDrink() {
        return itemRepository.findDrink();
    }

}
