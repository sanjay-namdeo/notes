## API Security

### Data Protection
Define clear access rights, especially for methods like
/DELETE/ delete a resource
/PUT/ updates a resource
These should be accessed by authenticated users only. For each call, an audit record must be saved.

### TLS
Transport Layer Security and its predecessor, Secure Sockets Layer(SSL) are cryptographic protocols.

When secured by TLS, connections between a client and server have one or more of the following properties:
1. The connection is private(or secure) because symmetric cryptography is used to encrypt the data transmitted.
2. The keys for this symmetric encryption are generated uniquely for each connection and are based on a shared secret negotiated at the start of the session.
3. The identity of the communication parties can be authenticated using public-key cryptography.
4. The connection ensures integrity because each message transmitted includes a message integrity check using a message authentication code to prevent undetected loss or alteration of the data transition.

### BASIC Authentication
1. Simplest technique for enforcing access controls to web resource because it doesn't require cookies, session identifiers, or login pages; 
2. *It uses standard fields in the HTTP header, removing the need for handshakes*.
3. Client sends userid and password, separated by a single colon (":") character, with a Base64 encoded string in the credentials.
`Authorization: Basic Qwhxnasuthadtere=`
4. Neither secure method nor protects the entity which is transmitted in cleartext across the physical network used as the carrier.
5. To protect sensitive and valuable information, it must use TLS/SSL protocols(HTTPS)

### API Keys
1. *Public REST services without access controls* run the risk of being farmed, leading to excessive bills for bandwidth or compute cycles. /API keys can be used to mitigate this risk/
2. Also used by organization to *monetize* APIs; instead of blocking high-frequency calls, clients are given access in accordance to a purchased access plan.

### SAML - Security Assessment Markup Language
XML based framework for authentication and authorization between two entities: a Service Provider and an Identity Provider

*Service Provider* agrees to trust the identity provider to authenticate users.

*Identity Provider* in return generates an authentication assertion, which indicates that a user has been authenticated.

SAML is a standard Single sign-on (SSO) format. Authentication information is exchanged through digitally signed XML documents. It's a complex SSO implementation that enables seamless authentication, mostly between businesses and enterprises.

### OAuth 2 - Open Standard for Authentication
Provides authorization workflow over HTTP and authorizes devices, servers, applications and APIs with access tokens instead of credentials.

It can be used to read data of a user from another application without compromising the user's personal and sensitive data, like user credentials.

OAuth 1.0 was complicated. In OAuth 2.0, it is no longer required to sign each call with a keyed hash,

_ *Access token* sent like an API key. It allows the application to access a user's data; optionally, access token can expire.
_ *Refresh token* optional. Retrieve a new access token if they have expired.

Since an access token is like a special type of API key, the most likely place to put it is in the authorization header, like
```
Authorization: Bearer 1234325h2jjkhfshdfjlkfds=
```

*OAuth 2 Actors*
*Resource Owner* owns the data in the resource server. ...
*Resource Server* The API which stores data the application wants to access.
*Client* the application that wants to access your data.
*Authorization Server* The main engine of OAuth.

### JSON WEB TOKEN (JWT)
It is an open standard extension of OAuth 2.0 for creating access tokens that assert some number of chains.
