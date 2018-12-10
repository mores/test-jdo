package org.datanucleus.test;

import java.util.*;
import org.junit.*;
import javax.jdo.*;

import static org.junit.Assert.*;
import mydomain.model.*;
import org.datanucleus.util.NucleusLogger;

public class SimpleTest
{
    @Test
    public void testSimple()
    {
        NucleusLogger.GENERAL.info(">> test START");
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try
        {
            tx.begin();

            // [INSERT code here to persist object required for testing]
	    Account acct = new Account();

	    BillAddress addr1 = new BillAddress();
	    addr1.setAccount( acct );
	    acct.getBillAddresses().add( addr1 );

	    ShipAddress addr2 = new ShipAddress();
	    addr2.setAccount( acct );
            acct.getShipAddresses().add( addr2 );

	    pm.makePersistent( acct );

		/*
	    javax.jdo.Query query = pm.newQuery( Address.class );
	    java.util.List<Address> results = query.executeList();
	    for( Address address : results )
	    {
		    System.out.println( "address: " + address + "\t" + address.getAccount() );
	    }
	    	*/

	    /*
	    javax.jdo.Query query = pm.newQuery( Account.class );
	    long deleted = query.deletePersistentAll();
	    System.out.println( "deleted: " + deleted );
	    */

            tx.commit();
        }
        catch (Throwable thr)
        {
            NucleusLogger.GENERAL.error(">> Exception in test", thr);
            fail("Failed test : " + thr.getMessage());
        }
        finally 
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }

        pmf.close();
        NucleusLogger.GENERAL.info(">> test END");
    }
}
