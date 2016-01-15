package com.pixisolutions.iht

import grails.plugin.springsecurity.SpringSecurityService

class Payment {
    Long id
    String note;

    Date dateCreated
    Date lastUpdated

    User createdBy

    transient springSecurityService

    static hasMany = [
            balances: Balance
    ]

    static constraints = {
        id()
        note maxSize: 255
        balances display: false
        createdBy nullable: true, editable: false, display: false
    }

    static mapping = {
        table 'iht_payment'
        balances cascade: "all"
    }

    static transients = ['springSecurityService']

    def beforeInsert(){
        try{
            if(springSecurityService.currentUserId){
                createdBy = User.proxy(springSecurityService.currentUserId)
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
