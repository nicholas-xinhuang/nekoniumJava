# nekoniumJava
 How to use:
 1. Download lib
 2. Import lib to your project
 3. Run go-nekonium and enable the module if necessary (e.g.personal, admin)
 
 
 You could used the most commonly API by creating a Nekonium Object
 ```java
 // Create a new account
 Nekonium nuko = new Nekonium("http://127.0.0.1:8293");
 System.out.println(nuko.createNewAccount("Your password"));
 ```
  ```java
 // Check Balance
 Nekonium nuko = new Nekonium("Your address", "http://127.0.0.1:8293");
 System.out.println(nuko.getBalance(NukoUnit.nuko));
 ```
 
 ```java
 // Send Transaction
 Nekonium nuko = new Nekonium("Your address", "http://127.0.0.1:8293");
 nuko.unlock("Your password", 30);
 System.out.println(nuko.sendTransaction("Address to send", 1));
 ```
 
You could also call RPC directly by using GNekonium Object
```java
  Package com.example;
  import org.nekonium.jsonrpc.*;
  import java.net.MalformedURLException;
  public class main {
    public static void main(String[] args) throws MalformedURLException {
      Gnekonium gnekonium = new Gnekonium("http://127.0.0.1:8293");
      try {
        System.out.println(gnekonium.getRPC().eth_accounts()[0]);
      } catch (Exception e) {}
    }
  }
```
