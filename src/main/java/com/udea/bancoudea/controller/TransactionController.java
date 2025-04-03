package com.udea.bancoudea.controller;

import com.udea.bancoudea.DTO.TransactionDTO;
import com.udea.bancoudea.DTO.TransferRequestDTO;
import com.udea.bancoudea.service.TransactionService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactioFacade;
    public TransactionController(TransactionService transactioFacade) {this.transactioFacade = transactioFacade;}

    //Obtener todas las transacciones
    @GetMapping("/{accountNumber}")
    @Operation(
            summary = "Obtener todas las transacciones por número de cuenta",
            description = "Este Endpoint permite encontrar todas las transacciones realizadas por número de cuenta"
    )
    public ResponseEntity<List<TransactionDTO>> getTransactionsForAccount(@PathVariable String accountNumber) {
        List<TransactionDTO> transactions = transactioFacade.getTransactionsForAccount(accountNumber);
        return ResponseEntity.ok(transactions);
    }

    //Realizar tranferencia entre cuentas

}
