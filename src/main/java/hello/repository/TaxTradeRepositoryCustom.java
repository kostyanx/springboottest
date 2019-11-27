package hello.repository;

import hello.entities.ResetMatchedQtyInfoResponse;

import java.util.List;

public interface TaxTradeRepositoryCustom {

    List<ResetMatchedQtyInfoResponse> resetMatchedQtyAfterTradeDateTime();
}
