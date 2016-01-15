package com.pixisolutions.iht

import grails.plugin.springsecurity.annotation.Secured


@Secured(["ROLE_ADMIN", "ROLE_SUPERADMIN"])
class PaymentController {

    static scaffold = Payment;
}
