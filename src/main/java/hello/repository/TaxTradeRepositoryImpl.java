package hello.repository;

import hello.entities.ResetMatchedQtyInfoResponse;
import org.hibernate.query.criteria.internal.compile.ExplicitParameterInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TaxTradeRepositoryImpl implements TaxTradeRepositoryCustom {

    private final EntityManager taxEntityManager;

    // @Qualifier("taxEntityManager")
    public TaxTradeRepositoryImpl(EntityManager taxEntityManager) {
        this.taxEntityManager = taxEntityManager;
    }

    @Override
    public List<ResetMatchedQtyInfoResponse> resetMatchedQtyAfterTradeDateTime() {
        return taxEntityManager.createNativeQuery("SELECT * FROM reset_matched_qty_info_response", ResetMatchedQtyInfoResponse.class)
                .getResultList();
    }

    private <T> ExplicitParameterInfo<T> parameter(String name, Class<T> clazz) {
        return new ExplicitParameterInfo<>(name, null, clazz);
    }
}
