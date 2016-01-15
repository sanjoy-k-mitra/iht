package com.pixisolutions.iht

import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.annotation.Secured


@Secured(['ROLE_ADMIN', 'ROLE_SUPERADMIN'])
class DashboardController {

    def index() {
        return [
                entries: Account.executeQuery("SELECT a.name, sum(b.amount) FROM Account a join a.balances b group by a")
        ]
    }
}
