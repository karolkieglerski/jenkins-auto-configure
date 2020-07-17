#!groovy

import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInjector().getInstance(AdminWhitelistRule.class)

println "--> creating local user 'admin'"

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount('admin','admin')
instance.setSecurityRealm(hudsonRealm)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
instance.setAuthorizationStrategy(strategy)

instance.getDescriptor("jenkins.CLI").get().setEnabled(false)

instance.setMasterKillSwitch(true)

instance.save()
