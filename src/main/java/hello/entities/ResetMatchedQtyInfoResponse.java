package hello.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
public class
ResetMatchedQtyInfoResponse {

    @EmbeddedId
    private ResetMatchedQtyInfoResponseId resetMatchedQtyInfoResponseId;

    @Transient
    private Long sellId;
    @Transient
    private Long buyId;

    public ResetMatchedQtyInfoResponseId getResetMatchedQtyInfoResponseId() {
        return this.resetMatchedQtyInfoResponseId;
    }

    public Long getSellId() {
        return this.sellId;
    }

    public Long getBuyId() {
        return this.buyId;
    }

    public void setResetMatchedQtyInfoResponseId(ResetMatchedQtyInfoResponseId resetMatchedQtyInfoResponseId) {
        this.resetMatchedQtyInfoResponseId = resetMatchedQtyInfoResponseId;
    }

    public void setSellId(Long sellId) {
        this.sellId = sellId;
    }

    public void setBuyId(Long buyId) {
        this.buyId = buyId;
    }

    public String toString() {
        return "ResetMatchedQtyInfoResponse(resetMatchedQtyInfoResponseId=" + this.getResetMatchedQtyInfoResponseId() + ", sellId=" + this.getSellId() + ", buyId=" + this.getBuyId() + ")";
    }

    @Embeddable
    public static class ResetMatchedQtyInfoResponseId implements Serializable {
        @Column(name = "isin")
        private String isin;
        @Column(name = "contract_id")
        private String contractId;
        @Column(name = "class_code")
        private String classCode;
        @Column(name = "buy_trade_num")
        private String buyTradeNum;
        @Column(name = "buy_trade_date")
        private LocalDate buyTradeDate;
        @Column(name = "sell_trade_num")
        private String sellTradeNum;
        @Column(name = "sell_trade_date")
        private LocalDate sellTradeDate;
        @Column(name = "qty")
        private BigInteger qty;

        public String getIsin() {
            return this.isin;
        }

        public String getContractId() {
            return this.contractId;
        }

        public String getClassCode() {
            return this.classCode;
        }

        public String getBuyTradeNum() {
            return this.buyTradeNum;
        }

        public LocalDate getBuyTradeDate() {
            return this.buyTradeDate;
        }

        public String getSellTradeNum() {
            return this.sellTradeNum;
        }

        public LocalDate getSellTradeDate() {
            return this.sellTradeDate;
        }

        public BigInteger getQty() {
            return this.qty;
        }

        public void setIsin(String isin) {
            this.isin = isin;
        }

        public void setContractId(String contractId) {
            this.contractId = contractId;
        }

        public void setClassCode(String classCode) {
            this.classCode = classCode;
        }

        public void setBuyTradeNum(String buyTradeNum) {
            this.buyTradeNum = buyTradeNum;
        }

        public void setBuyTradeDate(LocalDate buyTradeDate) {
            this.buyTradeDate = buyTradeDate;
        }

        public void setSellTradeNum(String sellTradeNum) {
            this.sellTradeNum = sellTradeNum;
        }

        public void setSellTradeDate(LocalDate sellTradeDate) {
            this.sellTradeDate = sellTradeDate;
        }

        public void setQty(BigInteger qty) {
            this.qty = qty;
        }

        public String toString() {
            return "ResetMatchedQtyInfoResponse.ResetMatchedQtyInfoResponseId(isin=" + this.getIsin() + ", contractId=" + this.getContractId() + ", classCode=" + this.getClassCode() + ", buyTradeNum=" + this.getBuyTradeNum() + ", buyTradeDate=" + this.getBuyTradeDate() + ", sellTradeNum=" + this.getSellTradeNum() + ", sellTradeDate=" + this.getSellTradeDate() + ", qty=" + this.getQty() + ")";
        }
    }
}
