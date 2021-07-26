package io.github.andreepdiasmeli.apirestaurante.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.andreepdiasmeli.apirestaurante.entity.Order;
import io.github.andreepdiasmeli.apirestaurante.entity.OrderItem;
import io.github.andreepdiasmeli.apirestaurante.entity.Table;
import org.springframework.stereotype.Repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class TableRepository  {

    public TableRepository() {
    }

    public List<Table> loadTables(){
        List<Table> tables = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            File file = new File("src/main/resources/database/tables.json");
            tables = Arrays.asList(mapper.readValue(file, Table[].class));

            for(Table table : tables){
                for(Order order : table.getOrders()){
                    for(OrderItem orderItem : order.getOrderItems()){
                        orderItem.setOrder(order);
                    }
                    order.setTable(table);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Falha ao abrir o arquivo tables.json .");
        }

        tables = new ArrayList<>(tables);
        return tables;
    }

    public void saveTables(List<Table> tables){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.registerModule(new JavaTimeModule());

        try {
            String path = "src/main/resources/database/tables.json";
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter out = new BufferedWriter(fileWriter);
            String tablesJSONString = objectMapper.writeValueAsString(tables);
            out.write(tablesJSONString);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Table findById(Long id) {
        List<Table> tables = loadTables();
        return filterById(id, tables);
    }

    private Table filterById(Long id, List<Table> tables) {
        return tables.stream().filter(t -> t.getId() == id).findFirst().orElseThrow(() ->
                new RuntimeException("Mesa com id " + id + " não foi encontrada.")
        );
    }

    public void save(Table table) {
        List<Table> tables = loadTables();
        Table persistedTable = filterById(table.getId(), tables);
        Integer persistedTableIndex = tables.indexOf(persistedTable);
        tables.set(persistedTableIndex, table);
        saveAll(tables);
    }

    public void saveAll(List<Table> tables) {
        saveTables(tables);
    }
}
