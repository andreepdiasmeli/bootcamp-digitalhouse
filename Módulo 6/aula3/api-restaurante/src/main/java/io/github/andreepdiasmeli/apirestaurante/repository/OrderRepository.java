package io.github.andreepdiasmeli.apirestaurante.repository;

import io.github.andreepdiasmeli.apirestaurante.entity.Order;
import io.github.andreepdiasmeli.apirestaurante.entity.Table;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {

    private final TableRepository tableRepository;

    public OrderRepository(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public List<Order> findAll() {
        List<Table> tables = tableRepository.loadTables();
        return tables.stream()
                .flatMap(t -> t.getOrders().stream())
                .collect(Collectors.toList());
    }

    public Order findById(Long id) {
        List<Order> orders = findAll();
        return orders.stream().filter(o -> o.getId() == id).findFirst().orElseThrow(() ->
                new RuntimeException("A ordem com id " + id + " não existe.")
        );
    }

    public void deleteById(Long id) {
        List<Table> tables = tableRepository.loadTables();
        for(Table table : tables){
            for(Order order : table.getOrders()){
                if(order.getId() == id){
                    table.getOrders().remove(order);
                    tableRepository.saveAll(tables);
                    return;
                }
            }
        }
        throw new RuntimeException("A ordem com id " + id + " não existe.");
    }

    public Order create(Order order) {
        List<Table> tables = tableRepository.loadTables();
        for(Table table : tables){
            if(table.getId() == order.getTableId()){
                order.setTable(table);
                table.getOrders().add(order);
                tableRepository.saveAll(tables);
                return order;
            }
        }
        throw new RuntimeException("O id da mesa informada não existe.");
    }

    public Order update(Order order) {
        List<Table> tables = tableRepository.loadTables();
        for(Table table : tables){
            if(table.getId() == order.getTableId()){
                for(int i = 0; i < table.getOrders().size(); i++){
                    Order realOrder = table.getOrders().get(i);
                    if(realOrder.getId() == order.getId()){
                        table.getOrders().set(i, order);
                        tableRepository.saveAll(tables);
                        return order;
                    }
                }
            }
        }
        throw new RuntimeException("O id da mesa ou ordem informada não existe.");
    }
}
