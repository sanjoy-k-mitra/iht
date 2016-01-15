import com.pixisolutions.iht.Account
import com.pixisolutions.iht.Balance
import com.pixisolutions.iht.Payment
import com.pixisolutions.iht.Role
import com.pixisolutions.iht.User
import com.pixisolutions.iht.UserRole
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.SpringSecurityUtils
import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        environments{
            production{

            }
            development{
                if(User.count() == 0){
                    Role userRole, adminRole, superAdminRole;
                    if(Role.count()==0){
                        userRole = new Role(authority: 'ROLE_USER').save(flush: true)
                        adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
                        superAdminRole = new Role(authority: 'ROLE_SUPERADMIN').save(flush: true)
                    }

                    User user = new User(username: 'user', password: 'user', enabled: true).save(flush: true)
                    User admin = new User(username: 'admin', password: 'admin', enabled: true).save(flush: true)
                    User superAdmin = new User(username: 'superadmin', password: 'superadmin', enabled: true).save(flush: true)

                    UserRole.create(user, userRole, true)
                    UserRole.create(admin, adminRole, true)
                    UserRole.create(superAdmin, superAdminRole, true)
                }
                if(Account.count() == 0){
                    new Account(name: 'Tution', isPayable: true, payableAmount: 3000).save(flush: true)
                    new Account(name: 'Sprots', isPayable: true, payableAmount: 300).save(flush: true)
                    new Account(name: 'Cultural', isPayable: true, payableAmount: 500).save(flush: true)
                    new Account(name: 'Library', isPayable: true, payableAmount: 100).save(flush: true)
                    new Account(name: 'Donation', isPayable: false, payableAmount: null).save(flush: true)
                }
                if(Payment.count() == 0){
                    new Payment(note: "09201901").save(flush: true)
                    new Payment(note: "09201902").save(flush: true)
                    new Payment(note: "09201903").save(flush: true)
                    new Payment(note: "09201904").save(flush: true)
                }
            }
            test{

            }
        }
    }
    def destroy = {
    }
}
