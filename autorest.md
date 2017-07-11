# HealthVault Rest Api
> see https://developer.healthvault.com/Api

## Getting Started
To build the API and Model helpers for the HealthVault Rest Api, first retrieve the latest swagger definition file from:
> https://developer.healthvault.com/swagger/khv.json

Save it in the same directory as autorest.md.

Note the version string (IE - 1.0-preview2) inside the .json file.
Update the value for restApiVersion in HealthVaultRestClient.java with the new version string.

Then use AutoRest via `npm` (`npm install -g autorest`) to run:
> `autorest autorest.md`

## Configuration

``` yaml
input-file: khv.json

java:
  namespace: com.microsoft.healthvault.restapi
  output-folder: healthvault/src/main/java/com/microsoft/healthvault/restapi
  add-credentials: true
```
