package com.microservice.accounts.movements.microservice2.service;

import java.time.LocalDate;
import java.util.List;

import com.microservice.accounts.movements.microservice2.dto.AccountStatementDto;

public interface AccountStatementService {

    List<AccountStatementDto> getReport(LocalDate startDate, LocalDate endDate);

}
