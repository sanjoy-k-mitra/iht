package com.pixisolutions.iht

import grails.plugin.springsecurity.SpringSecurityService

class Expense {

    Long id
    String note
    Double amount
    Account account

    Date dateCreated
    Date lastUpdated

    Balance balance

    User createdBy

    transient springSecurityService

    static transients = ['springSecurityService']

    static constraints = {
        account()
        amount()
        note nullable: true

        balance display: false, nullable: true
        createdBy nullable: true, editable: false, display: false
    }

    static mapping = {
        table 'iht_expences'
    }

    def beforeInsert(){
        try{
            if(springSecurityService.currentUserId){
                createdBy = User.proxy(springSecurityService.currentUserId)
            }
        }catch (MissingPropertyException err){}
        balance = new Balance(amount: -1*amount, account: account)
        balance.save()
    }

    def beforeUpdate(){
        balance.account = account
        balance.amount = amount
        balance.save()
    }
}
