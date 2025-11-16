package com.forxt.foreign_exchange_transaction.repository;

import com.forxt.foreign_exchange_transaction.model.Fx_deal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FxDealRepository extends JpaRepository<Fx_deal, Long> {
    Optional<Fx_deal> findByDealUniqueId(String dealUniqueId);
}
