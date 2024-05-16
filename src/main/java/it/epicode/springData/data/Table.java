package it.epicode.springData.data;

import jakarta.persistence.*;
import lombok.*;

@Entity
@jakarta.persistence.Table(name = "tables")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(setterPrefix = "with")
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numTable;

    @Column (name = "num_max_coperti")
    private int numMaxCoperti;
    @Column (name = "is_free")
    private boolean isFree;
    @Column (name = "costo_coperto")
    private double costoCoperto;

    public void print() {
        System.out.println("numero tavolo--> " + numTable);
        System.out.println("numero massimo coperti--> " + numMaxCoperti);
        System.out.println("occupato/libero--> " + (this.isFree ? "Libero" : "Occupato"));
    }
}
