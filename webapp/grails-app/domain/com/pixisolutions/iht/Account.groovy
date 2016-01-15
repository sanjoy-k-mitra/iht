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

    transient springSecurityService

    static hasMany = [balances: Balance]

    static constraints = {
        id()
        name maxSize: 255
        isPayable()
        payableAmount min: 0d, max: 10000000d, nullable: true
        balances display: false
        createdBy nullable: true, editable: false, display: false
    }

    static mapping = {
        table 'iht_account'
    }

    static transients = ['springSecurityService']

    def beforeInsert() {
        try{
            if (springSecurityService.getCurrentUserId()) {
                createdBy = User.proxy(springSecurityService.getCurrentUserId())
            }
        }catch (Exception err){}
    }
}
