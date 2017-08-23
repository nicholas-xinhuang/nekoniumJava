﻿# nekoniumJava
 How to use:
 1. Download lib
 2. Import lib to your project
 3. Run go-nekonium and enable the module if necessary (e.g.personal, admin)
 
 Example:
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
