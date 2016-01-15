package com.pixisolutions.iht

import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_USER")
class ProfileController {

    def index() {
        render "Profile"
    }
}
