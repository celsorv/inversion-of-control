## Inversion of Control (IoC) and Dependency Injection (DI)

### Imagine that an email is sent in different tasks spread across the system, and now you need to change the password!

```
public class Order {

    public void save() {
        // Save order and send confirmation email
        
        var = new SendEmails("stmp", "contact@email.com", "password");
        sendEmails.success("Order created!");
    }
}
```

```
public class Customer {

    public void save() {
        // Save customer and send confirmation email
        
        var sendEmails = new SendEmails("stmp", "contact@email.com", "password");
        sendEmails.success("Customer data has been changed!");
    }
}
```
<br>


### Much better if you could make this change in just one place!
#### The Sendmail class that takes care of everything that involves sending emails.

```
public class SendEmails {

    private SendEmails(String tipo, String endereco, String senha) {
    }
    
    // -=-=-=-=-=-=-=-=-=-=-=-=-=-
    // Email data centralized here
    // -=-=-=-=-=-=-=-=-=-=-=-=-=-
    public static SendEmails getDataEmail() {
        return new SendEmails("smtp", "contact@email.com", "password");
    }
    
}
```

### The Order, Customer classes just want it shipped!

```
public class Order {

    // -=-=-=-=-=-=-=-=-=-=-=-=-
    // Dependency Injection (DI)
    // -=-=-=-=-=-=-=-=-=-=-=-=-
    private final var sendEmails = SendEmails.getDataEmail();

    public void save() {
        sendEmails.success("Order created!");
    }
}
```

### And then we have a single point of change and, via dependency injection, SendEmails is available wherever you need it.