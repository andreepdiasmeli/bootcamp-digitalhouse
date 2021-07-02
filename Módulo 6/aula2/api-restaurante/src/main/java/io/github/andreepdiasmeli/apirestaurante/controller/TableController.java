package io.github.andreepdiasmeli.apirestaurante.controller;

import io.github.andreepdiasmeli.apirestaurante.dtos.TableInfoDTO;
import io.github.andreepdiasmeli.apirestaurante.service.TableService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/table")
public class TableController {

    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping("{id}")
    public TableInfoDTO getTableInfo(@PathVariable Long id){
        TableInfoDTO tableInfo = null;
        try{
            tableInfo = tableService.getTableInfo(id);
        }catch (RuntimeException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
        return tableInfo;
    }

    @GetMapping("{id}/close")
    public String closeTable(@PathVariable Long id){
        try{
            tableService.closeTable(id);
        }catch (RuntimeException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
        return "A mesa " + id + " foi fechada com sucesso.";
    }

}
