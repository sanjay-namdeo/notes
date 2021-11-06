# Java Keystore

## Get a certificate from host and port
```bash
openssl s_client -connect ${HOST}:${PORT} </dev/null > ${HOST}.cert
```

## Import using keytool
```bash
keytool -import -noprompt -trustcacerts -alias ${HOST} -file ${HOST}.cert keystore ${KEYSTOREFILE} -storepass ${KEYSTOREPASS}
```
