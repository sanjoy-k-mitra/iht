package com.pixisolutions.iht

import grails.plugin.springsecurity.SpringSecurityService

class Account {
    Long id
    String name;
    Boolean isPayable;
    Double payableAmount;

    Date dateCreated
    Date lastUpdated

    User createdBy

    static hasMany = [balances: Balance]

    static constraints = {
        payableAmount min: 0d, max: 10000000d, nullable: true
        balances display: false
        createdBy nullable: true
    }

    static mapping = {
        table 'iht_account'
    }

    def beforeInsert() {
        try{
            if (SpringSecurityService.currentUserId) {
                createdBy = User.proxy(SpringSecurityService.currentUserId)
            }
        }catch (MissingPropertyException err){}
    }
}
