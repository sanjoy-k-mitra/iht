package com.pixisolutions.iht

import grails.plugin.springsecurity.annotation.Secured


@Secured('ROLE_SUPERADMIN')
class UserController {

    static scaffold = User
}
