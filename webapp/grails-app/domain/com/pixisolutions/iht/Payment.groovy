package com.pixisolutions.iht

import grails.plugin.springsecurity.SpringSecurityService

class Payment {
    Long id
    String note;

    Date dateCreated
    Date lastUpdated

    User createdBy

    static hasMany = [
            balances: Balance
    ]

    static constraints = {
        balances display: false
        createdBy nullable: true
    }

    static mapping = {
        table 'iht_payment'
        balances cascade: "all"
    }



    def beforeInsert(){
        try{
            if(SpringSecurityService.currentUserId){
                createdBy = User.proxy(SpringSecurityService.currentUserId)
            }
        }catch (MissingPropertyException err){}
        balances = new ArrayList<Balance>()
        Account.where {
            isPayable == true
        }.list().each {
            balances.add(new Balance(account: it, amount: it.payableAmount, payment: this))
        }
    }

}
