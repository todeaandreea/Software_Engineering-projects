package isp.lab7.safehome;

public class TenantNotFoundException extends Exception
{
    public String getMessage() {return "Tenant Not Found Exception";}
}
