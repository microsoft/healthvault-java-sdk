This project comprises an SDK to access HealthVault and a sample ui 
allowing a user to view and add weight measurements.  

Building:
    The build environment relies on Maven.  (http://maven.apache.org) 
    The UI relies on the SDK.  The SDK should be built first and installed in 
    the maven repository.

    Build:
    > cd sdk
    > mvn install
    > cd ../ui
    > mvn package


    Javadoc:
    > cd sdk
    > mvn javadoc:javadoc
    > cd ui
    > mvn javadoc:javadoc

    Create Eclipse environment
    > cd sdk
    > mvn eclipse:eclipse
    > cd ui
    > mvn eclipse:eclipse

    Now import projects into Eclipse: File-->Import.
    In Project-->Properties-->Build Path, configure the M2_REPO variable to 
    point at your maven repository.  This is probably in 
    <user_home>/.m2/repository.  If you miss or skip this step, eclipse will 
    complain that it cannot find its dependencies.

Running the Sample:
    You can run the app directly from the command line with maven:
    > mvn jetty:run
    Point your web browser at http://localhost:8080/jwildcat-1.4

    You can run the web app directly from within Eclipse.  Select the UI 
    project, then Run As-->Java Application.  Otherwise, take the war produced 
    from your build above located at ui/target/jwildcat-ui.*.*-SNAPSHOT.war
    and install it in your servlet container. 

Private Key:
    Healthvault uses public/private key infrastructure to verify the 
    application.  It does not validate the public key certificate chain so 
    there is no need to obtain keys from a trusted CA.  The healthvault java 
    sdk uses the JSSE keystore to obtain the application's private key.  The 
    keystore file is loaded from the classpath and is shipped with the name 
    "/keystore".  The following entries in hv-application configure its use:

    keystore.filename=/keystore
    keystore.keyname=java-wildcat
    keystore.password=password

    The jdk ships with a tool to create and manage keys within this store: keytool 
    (http://java.sun.com/javase/6/docs/technotes/tools/windows/keytool.html)

    The instructions for how to generate a public/private key pair are 
    described in the documentation for the 
    com.microsoft.hsg.DefaultPrivateKeyStore class:

    keytool -genkeypair -keyalg RSA -keysize 1024 -keystore keystore -alias java-wildcat -validity 9999

    This creates a file named "keystore" if it doesn't already exist and the 
    generated keys are placed within.  The password for the keystore and the 
    key must be the same.  You may choose other values for the keystore name 
    and the key alias, but they must correspond to configuration values in 
    hv-application.properties.

    The public key certificate must then be exported from the key store and 
    sent to the partner team.  

    To export the key:

    keytool -export -alias java-wildcat -keystore keystore > my-pub.cer

    Send the my-pub.cer file to the HealthVault team and we’ll take care of 
    the rest.

Making SDK Requests:
    The application is responsible for marshaling and unmarshaling the <info> 
    section in each HV Request.  You can find detailed schemas for each 
    method here:  http://developer.healthvault.com/methods/methods.aspx.

SSL:
    HealthVault requires requests be sent over SSL. Our site's certificates are
    signed with GTE CyberTrust Global Root as the trusted root certificate 
    authority. This public key is shipped with Sun’s java runtime in a file 
    located at java.home/lib/security/cacerts. The alias for this key is 
    "gtecybertrustglobalca".  Depending on your JRE or environment, this
    public key may not be installed in your trusted store.  This is a known
    issue with WebSphere.

    To export the key from the cacerts file:

    keytool -keystore cacerts -exportcert -alias gtecybertrustglobalca > gte.crt

    This public key should then be imported into WebSphere’s trusted store.

