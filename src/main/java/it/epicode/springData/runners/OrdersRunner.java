package it.epicode.springData.runners;

import it.epicode.springData.U4S5L4SpringDataApplication;
import it.epicode.springData.data.*;
import it.epicode.springData.data.enums.OrderStatus;
import it.epicode.springData.services.ItemService;
import it.epicode.springData.services.MenuService;
import it.epicode.springData.services.OrderService;
import it.epicode.springData.services.TableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Component
@Slf4j

public class OrdersRunner implements CommandLineRunner {


    @Autowired
    MenuService menuS;

    @Autowired
    TableService table;

    @Autowired
    OrderService order;

    @Autowired
    ItemService item;


    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U4S5L4SpringDataApplication.class);
        try {
            Table table1 = ctx.getBean("Tavolo1", Table.class);
            Table table2 = ctx.getBean("Tavolo2", Table.class);
            Table table3 = ctx.getBean("Tavolo3", Table.class);
            table.saveTable(table1);
            table.saveTable(table2);
            table.saveTable(table3);

            Menu menu = new Menu("Menù del giorno");
            menuS.saveMenu(menu);

            Topping tomato = ctx.getBean("toppings_tomato", Topping.class);
            tomato.setMenu(menu);
            Topping cheese = ctx.getBean("toppings_cheese", Topping.class);
            cheese.setMenu(menu);
            Topping ham = ctx.getBean("toppings_ham", Topping.class);
            ham.setMenu(menu);
            Topping pineapple = ctx.getBean("toppings_pineapple", Topping.class);
            pineapple.setMenu(menu);
            Topping salami = ctx.getBean("toppings_salami", Topping.class);
            salami.setMenu(menu);
            Pizza margherita = ctx.getBean("pizza_margherita", Pizza.class);
            margherita.setMenu(menu);
            Pizza hawaiian = ctx.getBean("hawaiian_pizza", Pizza.class);
            hawaiian.setMenu(menu);
            Pizza salamiPizza = ctx.getBean("salami_pizza", Pizza.class);
            salamiPizza.setMenu(menu);
            Drink lemonade = ctx.getBean("lemonade", Drink.class);
            lemonade.setMenu(menu);
            Drink water = ctx.getBean("water", Drink.class);
            water.setMenu(menu);
            Drink wine = ctx.getBean("wine", Drink.class);
            wine.setMenu(menu);

            item.saveItem(tomato);
            item.saveItem(cheese);
            item.saveItem(ham);
            item.saveItem(pineapple);
            item.saveItem(salami);

//            List<Item> order1items = new ArrayList<>();
//            order1items.add(hawaiian);
//            order1items.add(lemonade);
//            order1items.add(salami);
//            order1items.add(wine);
//
//            Order order1 = new Order (3, table3);
//            order1.setOrderStatus(OrderStatus.SERVITO);
//            order1.setOraAcquisizione(LocalTime.now());
//            order1.setOrderedProducts(order1items);
//
//            order.saveOrder(order1);

        } catch (BeansException e) {
            throw new RuntimeException(e);
        } finally {
            ctx.close();
        }
    }

}

