package com.pixisolutions.iht

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER', 'ROLE_ADMIN', 'ROLE_SUPERADMIN'])
class RedirectController {

    def index() {
        if(SpringSecurityUtils.ifAllGranted('ROLE_USER')){
            redirect(controller: 'profile', action: 'index')
        }
        if(SpringSecurityUtils.ifAllGranted('ROLE_ADMIN')){
            redirect(controller: 'dashboard', action: 'index')
        }
        if(SpringSecurityUtils.ifAllGranted('ROLE_SUPERADMIN')){
            redirect(controller: 'dashboard', action: 'index')
        }
    }
}
