# jdk17-jakartaEE8

Demo project to demonstrate the usage of JDK 17 language features with Jakarta EE 8 and Payara Micro.

## Steps

- Make sure you have installed JDK 17 and downloaded Payara Micro 5.2021.8 or later.
- Build and package the application; `mvn clean package`.
- Start application using Payara Micro `java -jar payara-micro.jar <path-to-record17.war`.
- Test application using +
   `curl localhost:8080/record17/api/query/countries/Europe` +
   `curl localhost:8080/record17/api/query/country/olympic/56`


## Description

When using the Maven war plugin on JDK 17, make sure you use version _3.3.1_ or later as otherwise you encounter exceptions due to the stricter encapsulation of JDK internals.

`fish.payara.jdk17.CountryDTO` defines a JDK 17 Record and the workaround you need to have it recognized by the JSONB specification.

`fish.payara.jdk17.service.CountryService.getCountries` uses the Record constructor within a Stream. It also indicates the pitfall with `Stream.toList()`. 

The method `fish.payara.jdk17.QueryResource.get()` has an example of a Text block and the Switch Expression.

`fish.payara.jdk17.model.Country.equals` showcases a typical usage of the pattern matching with _instanceof_.