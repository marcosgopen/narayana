package com.hp.mwtests.ts.jta.cdi.serializability;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.arjuna.ats.jta.cdi.TransactionExtension;

import jakarta.enterprise.inject.spi.Extension;
import jakarta.inject.Inject;

/**
 * Tests that bean requiring serialization can be intercepted with {@code Transactional}, e.g. that the interceptor
 * behind it is serializable as well.
 *
 * @author Matej Novotny <manovotn@redhat.com>
 */
@RunWith(Arquillian.class)
public class TransactionalInterceptorIsSerializableTest {

    @Inject
    SessionFoo foo;

    @Deployment
    public static JavaArchive createTestArchive() {

        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addClass(SessionFoo.class)
                .addAsServiceProvider(Extension.class, TransactionExtension.class)
                .addAsManifestResource(new StringAsset("<beans bean-discovery-mode=\"all\"></beans>"), "beans.xml");
    }

    @Test
    public void testFooBeanCanBeUsed() {
        // just pinging it will do, this test would blow up at bootstrap if there was a problem
        Assert.assertEquals(SessionFoo.class.getSimpleName(), foo.ping());
    }
}
