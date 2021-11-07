```java
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
//VERY IMPORTANT.  SOME OF THESE EXIST IN MORE THAN ONE PACKAGE!
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

//Put everything after here in your function.
KeyStore trustStore  = KeyStore.getInstance(KeyStore.getDefaultType());
trustStore.load(null);//Make an empty store
InputStream fis = /* insert your file path here */;
BufferedInputStream bis = new BufferedInputStream(fis);

CertificateFactory cf = CertificateFactory.getInstance("X.509");

while (bis.available() > 0) {
    Certificate cert = cf.generateCertificate(bis);
    trustStore.setCertificateEntry("fiddler"+bis.available(), cert);
}
```
