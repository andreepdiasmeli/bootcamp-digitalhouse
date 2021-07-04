package io.github.andreepdiasmeli.apirestaurante.service;

import io.github.andreepdiasmeli.apirestaurante.dtos.OrderDTO;
import io.github.andreepdiasmeli.apirestaurante.dtos.TableInfoDTO;
import io.github.andreepdiasmeli.apirestaurante.entity.Table;
import io.github.andreepdiasmeli.apirestaurante.repository.TableRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableService {

    private final CashRegisterService cashRegisterService;
    private final TableRepository tableRepository;

    public TableService(TableRepository tableRepository, CashRegisterService cashRegisterService) {
        this.tableRepository = tableRepository;
        this.cashRegisterService = cashRegisterService;
    }

    public Table getById(Long id){
        return tableRepository.findById(id);
    }

    public TableInfoDTO getTableInfo(Long id) {
        Table table = getById(id);

        List<OrderDTO> orders = table.getOrders().stream().map(o -> OrderDTO.toDTO(o)).collect(Collectors.toList());

        return new TableInfoDTO(table.getId(), table.getTotalAmount(), orders);
    }

    public void closeTable(Long id) {
        Table table = getById(id);

        BigDecimal totalTableAmount = table.getTotalAmount();
        cashRegisterService.addAmount(totalTableAmount);

        table.resetTotalAmount();
        table.getOrders().clear();

        tableRepository.save(table);
    }
}
