package com.pixisolutions.iht

import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_SUPERADMIN")
class UserRoleController {

    static scaffold = UserRole
}
