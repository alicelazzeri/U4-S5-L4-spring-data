package it.epicode.springData.data;

import it.epicode.springData.data.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@jakarta.persistence.Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numeroOrdine;

    @Column
    private OrderStatus state;
    @Column (name = "num_coperti")
    private int numCoperti;
    @Column (name = "ora_acquisizione")
    private LocalTime oraAcquisizione;
    @Column (name = "ordered_products")
    private List<Item> orderedProducts;
    @Column
    private Table table;

    public Order(int numCoperti, Table table) {
        Random rndm = new Random();
        if (table.getNumMaxCoperti() <= numCoperti)
            throw new RuntimeException("Numero coperti maggiore di numero massimo posti sul tavolo!");
        this.numeroOrdine = rndm.nextInt(1000, 100000);
        this.state = OrderStatus.IN_CORSO;
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
        System.out.println("stato--> " + this.state);
        System.out.println("numero coperti--> " + this.numCoperti);
        System.out.println("ora acquisizione--> " + this.oraAcquisizione);
        System.out.println("numero tavolo--> " + this.table.getNumTable());
        System.out.println("Lista: ");
        this.orderedProducts.forEach(System.out::println);
        System.out.println("totale--> " + this.getTotal());

    }
}

