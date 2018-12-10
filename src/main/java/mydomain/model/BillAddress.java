package mydomain.model;

import javax.jdo.annotations.*;

@PersistenceCapable(detachable="true")
@Inheritance( strategy = InheritanceStrategy.NEW_TABLE )
public class BillAddress extends Address
{
}
