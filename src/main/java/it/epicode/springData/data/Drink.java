package it.epicode.springData.data;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "drinks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drink extends Item {
    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

}

