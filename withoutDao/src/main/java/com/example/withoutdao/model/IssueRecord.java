package com.example.withoutdao.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IssueRecord {
    int prn;
    int acc_no;

    public int getPrn() {
        return prn;
    }
    public void setPrn(int prn) {
        this.prn = prn;
    }
    public int getAcc_no() {
        return acc_no;
    }
    public void setAcc_no(int acc_no) {
        this.acc_no = acc_no;
    }

}
