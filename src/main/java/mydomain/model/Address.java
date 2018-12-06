package mydomain.model;

import javax.jdo.annotations.*;

@PersistenceCapable(detachable="true")
public class Address
{
    @PrimaryKey
    @Persistent( valueStrategy = IdGeneratorStrategy.IDENTITY )
    Long id;

    Account account;

    public Account getAccount()
    {
	    return account;
    }
}
