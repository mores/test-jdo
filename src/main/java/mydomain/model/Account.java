package mydomain.model;

import javax.jdo.annotations.*;

@PersistenceCapable(detachable="true")
public class Account
{
    @PrimaryKey
    @Persistent( valueStrategy = IdGeneratorStrategy.IDENTITY )
    Long id;

    @Persistent(mappedBy="account")
    @Element( types = Address.class, dependent="true" )
    @Join
    @Order(column="ORDER_IDX")
    java.util.Collection<Address> addresses = new java.util.ArrayList<>();

    public java.util.Collection<Address> getAddresses()
    {
	    return addresses;
    }
}
