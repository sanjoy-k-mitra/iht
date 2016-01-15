package com.pixisolutions.iht

class Balance {

    Account account;
    Payment payment;
    Double amount;
    static constraints = {
        payment nullable: true
    }

    static mapping = {
        table 'iht_balance'
    }
}
