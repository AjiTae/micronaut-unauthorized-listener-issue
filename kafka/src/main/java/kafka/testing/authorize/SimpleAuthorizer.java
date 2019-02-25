package kafka.testing.authorize;

import org.apache.kafka.common.security.auth.KafkaPrincipal;
import kafka.network.RequestChannel.Session;
import kafka.security.auth.*;

import scala.collection.immutable.Set;
import scala.collection.immutable.Map;

import org.apache.log4j.Logger;

public class SimpleAuthorizer implements Authorizer {
    private Logger log = Logger.getLogger("kafka.authorizer.logger");

    public SimpleAuthorizer(){
        log.info("Authorizer сreated.");
    }

    @Override
    public boolean authorize(Session session, Operation operation, Resource resource) {
        log.info(
            "Authorize, user: " + session.sanitizedUser() +
                ", topic: " +  resource.name() +
                ", operation: " +  operation.name()
        );

        if("kafka.testing.unauthorized".equals(resource.name())){
            log.info(
                "Authorize forbidden, user: " + session.sanitizedUser() +
                    ", topic: " +  resource.name() +
                    ", operation: " +  operation.name()
            );

            return false;
        }

        return true;
    }

    @Override
    public void addAcls(Set<Acl> set, Resource resource) {}

    @Override
    public boolean removeAcls(Set<Acl> set, Resource resource) {
        return false;
    }

    @Override
    public boolean removeAcls(Resource resource) {
        return false;
    }

    @Override
    public Set<Acl> getAcls(Resource resource) {
        return null;
    }

    @Override
    public Map<Resource, Set<Acl>> getAcls(KafkaPrincipal kafkaPrincipal) {
        return null;
    }

    @Override
    public Map<Resource, Set<Acl>> getAcls() {
        return null;
    }

    @Override
    public void close() {}

    @Override
    public void configure(java.util.Map<String, ?> map) {}
}
