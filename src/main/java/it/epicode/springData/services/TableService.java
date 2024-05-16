package it.epicode.springData.services;

import it.epicode.springData.data.Table;
import it.epicode.springData.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    @Autowired
    TableRepository tableRepository;

    public List<Table> findAllTables() {
        return tableRepository.findAll();
    }

    public Table findTableById(int id) {
        return tableRepository.findById(id).orElse(null);
    }

    public void saveTable(Table table) {
        tableRepository.save(table);
    }

    public void deleteTable(int id) {
        tableRepository.deleteById(id);
    }

}
