package com.microservice.accounts.movements.microservice2.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

@Repository
public class AccountStatementRepository {

        @Autowired
        private final EntityManager entityManager;

        public AccountStatementRepository(EntityManager entityManager) {
                this.entityManager = entityManager;
        }

        @SuppressWarnings("unchecked")
        public List<Object[]> findAccountStatement(LocalDate startDate, LocalDate endDate) {
                String sql = "SELECT " +
                             "a.acc_number, " +
                             "a.acc_type, " +
                             "a.acc_balance AS saldo_inicial, " +
                             "m.mov_value AS movimiento, " +
                             "(a.acc_balance + m.mov_value) AS saldo_disponible, " +
                             "m.mov_date AS fecha, " +
                             "p.per_name AS cliente, " +
                             "a.acc_state AS estado " +
                             "FROM tbl_movements m " +
                             "JOIN tbl_accounts a ON m.acc_code = a.acc_code " +
                             "JOIN tbl_clients c ON a.cli_code = c.cli_codigo " +
                             "JOIN tbl_persons p ON c.per_codigo = p.per_codigo " +
                             "WHERE m.mov_date BETWEEN :startDate AND :endDate";
        
                jakarta.persistence.Query query = this.entityManager.createNativeQuery(sql);
                query.setParameter("startDate", startDate);
                query.setParameter("endDate", endDate);
        
                return query.getResultList();
            }

}
