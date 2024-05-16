package it.epicode.springData.repositories;

import it.epicode.springData.data.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table, Integer> {
}
