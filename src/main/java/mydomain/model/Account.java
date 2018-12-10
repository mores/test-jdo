package mydomain.model;

import javax.jdo.annotations.*;

@PersistenceCapable(detachable="true")
public class Account
{
    @PrimaryKey
    @Persistent( valueStrategy = IdGeneratorStrategy.IDENTITY )
    Long id;

    @Persistent
    @Element( types = BillAddress.class, dependent="true", mappedBy="account" )
    @Join
    @Order(column="ORDER_IDX")
    java.util.Collection<BillAddress> billAddresses = new java.util.ArrayList<>();

    public java.util.Collection<BillAddress> getBillAddresses()
    {
            return billAddresses;
    }

    @Persistent
    @Element( types = ShipAddress.class, dependent="true", mappedBy="account" )
    @Join
    @Order(column="ORDER_IDX")
    java.util.Collection<ShipAddress> shipAddresses = new java.util.ArrayList<>();

    public java.util.Collection<ShipAddress> getShipAddresses()
    {
            return shipAddresses;
    }
}
