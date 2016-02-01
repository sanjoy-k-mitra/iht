package com.pixisolutions.iht

class Balance {
    Double amount;

    static belongsTo = [
            account: Account,
            payment: Payment
    ]
    static constraints = {
        payment nullable: true
    }

    static mapping = {
        table 'iht_balance'
    }

    String toString(){
        return "[${account.name}, ${amount}]";
    }
}
