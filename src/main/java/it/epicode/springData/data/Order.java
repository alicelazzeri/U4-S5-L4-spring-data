package it.epicode.springData.data;

import it.epicode.springData.data.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.Getter;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@jakarta.persistence.Table(name = "orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int numeroOrdine;
    private OrderStatus orderStatus;
    private int numCoperti;
    private LocalTime oraAcquisizione;
	/*@ManyToMany
	@JoinTable(name = "items_orders",
			joinColumns = @JoinColumn(name = "item"),
			inverseJoinColumns = @JoinColumn(name = "order"))*/

    @ManyToMany
    @JoinTable(
            name = "orders_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> orderedProducts;
    @ManyToOne
    private Table table;

    public Order(int numCoperti, Table table) {
        Random rndm = new Random();
        if (table.getNumMaxCoperti() <= numCoperti)
            throw new RuntimeException("Numero coperti maggiore di numero massimo posti sul tavolo!");
        this.numeroOrdine = rndm.nextInt(1000, 100000);
        this.orderStatus = OrderStatus.IN_CORSO;
        this.numCoperti = numCoperti;
        this.oraAcquisizione = LocalTime.now();
        this.orderedProducts = new ArrayList<>();
        this.table = table;
    }

    public void addItem(Item item) {
        this.orderedProducts.add(item);
    }

    public double getTotal() {
        return this.orderedProducts.stream().mapToDouble(Item::getPrice).sum() + (this.table.getCostoCoperto() * this.numCoperti);
    }

    public void print() {
        System.out.println("id ordine--> " + this.numeroOrdine);
        System.out.println("stato--> " + this.orderStatus);
        System.out.println("numero coperti--> " + this.numCoperti);
        System.out.println("ora acquisizione--> " + this.oraAcquisizione);
        System.out.println("numero tavolo--> " + this.table.getNumTable());
        System.out.println("Lista: ");
        this.orderedProducts.forEach(System.out::println);
        System.out.println("totale--> " + this.getTotal());

    }
}
