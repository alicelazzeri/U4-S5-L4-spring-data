package it.epicode.springData.services;

import it.epicode.springData.data.Menu;
import it.epicode.springData.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;

    public List<Menu> findAllMenus() {
        return menuRepository.findAll();
    }

    public Menu findMenuById(long id) {
        return menuRepository.findById(id).orElse(null);
    }

    public void saveMenu(Menu menu) {
        menuRepository.save(menu);
    }

    public void deleteMenu(long id) {
//        var item = this.findMenuById(id);
//        itemRepository.deleteItem(item);
        menuRepository.deleteById(id);
    }

}
