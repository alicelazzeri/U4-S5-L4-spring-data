package it.epicode.springData.repositories;

import it.epicode.springData.data.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
