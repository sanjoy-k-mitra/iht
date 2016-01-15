package com.pixisolutions.iht

import grails.plugin.springsecurity.annotation.Secured


@Secured(["ROLE_ADMIN", "ROLE_SUPERADMIN"])
class AccountController {

    static scaffold = Account;
}
