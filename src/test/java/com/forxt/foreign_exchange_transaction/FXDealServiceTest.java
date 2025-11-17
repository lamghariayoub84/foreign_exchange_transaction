package com.forxt.foreign_exchange_transaction;
import com.forxt.foreign_exchange_transaction.service.FXDealImportService;
import com.forxt.foreign_exchange_transaction.service.FXDealService;
import com.forxt.foreign_exchange_transaction.repository.FxDealRepository;
import com.forxt.foreign_exchange_transaction.model.Fx_deal;
import com.forxt.foreign_exchange_transaction.dto.DealRequestDto;
import com.forxt.foreign_exchange_transaction.service.IsoListeService;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class FXDealServiceTest {

    FxDealRepository fxDealRepository = mock(FxDealRepository.class);
    FXDealImportService fxDealImportService = mock(FXDealImportService.class);
    IsoListeService isoListeService = mock(IsoListeService.class);
    FXDealService service = new FXDealService(fxDealRepository,fxDealImportService,isoListeService);
    @Test
    void testSaveDealSuccess() {
        DealRequestDto dto = new DealRequestDto();
        dto.setDealUniqueid("D100");
        dto.setFromCurrency("USD");
        dto.setToCurrency("EUR");
        dto.setDealTimestamp(LocalDateTime.now());
        dto.setAmount(1000.0);

        when(fxDealRepository.findByDealUniqueId("D100")).thenReturn(Optional.empty());
        when(fxDealRepository.save(any(Fx_deal.class))).thenAnswer(i -> i.getArgument(0));

        Fx_deal result = service.saveDeal(dto);

        assertEquals("D100", result.getDealUniqueId());
        verify(fxDealRepository, times(1)).save(any(Fx_deal.class));
    }
    @Test
    void testSaveDealDuplicate() {
        DealRequestDto dto = new DealRequestDto();
        dto.setDealUniqueid("D101");
        dto.setFromCurrency("USD");
        dto.setToCurrency("EUR");
        dto.setDealTimestamp(LocalDateTime.now());
        dto.setAmount(1000.0);

        when(fxDealRepository.findByDealUniqueId("D101")).thenReturn(Optional.of(new Fx_deal()));

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> service.saveDeal(dto));

        assertEquals("Deal already exists with ID: D101", exception.getMessage());
    }
}
