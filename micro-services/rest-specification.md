## Rest Specification
### URI Construction
RESTful APIs use Uniform Resource Identifiers (URIs) to address resources, ONAP projects should comply with a unified URI standard to implement the microservices.
1. URI structure (Mandatory)
URI structure http://[host]:[port]/api/{service name}]/v{version number}/{resource}
The URI is comprised of a fixed base uri /api/{service name}]/v{version number} and the resource path. Only major version number is used in the URI. An example: http://127.0.0.1:8080/api/petstore/v1/pets/dogs
2. CRUD function names should not be used in URIs. Instead, CRUD actions should be represented by HTTP methods. Below is the proposed methodology to implement CRUD operations in a RESTful API. (Recommended)
```
*api/petstore/v1/pets/dogs*
*POST* creates a new dog
*GET* Lists dog
*PUT* Replace dog with new dog
*DELETE* Delete all dogs
```
3. A plural noun should be used for collection names (Mandatory)
For example, the URI for a collection of dog documents uses the plural noun form of its contained resources: /api/petstore/v1/pets/dogs
4. A singular noun should be used for document names (Mandatory)
For example, the URI for a single dog document would have the singular form: /api/petstore/v1/pets/dogs/bailey

### Versioning
API is a public contract between a Server and a Consumer, so it's crucial to make sure the changes are backwards compatible. We need to introduce new versions of the API while still allowing old versions to be accessible when it's necessary. So a versioning mechanism should be considered.

### Security
Token Based Authentication (Recommended)
Ideally, microservices should be stateless so the service instances can be scaled out easily and the client requests can be routed to multiple independent service providers. A token based authentication mechanism should be used instead of session based authentication

### HTTP response status codes
#### Error Payload
```
{
"message": "Sorry, the requested resource does not exist",
"code": 34
}
```

### Status codes
|Resonse Code|Response Summary|Response Description|
|---|---|---|
|200|OK|Everything is working|
|201|OK|New resource has been created|
|204|OK|The resource was successfully deleted|
|304|Not Modified|The client can use cached data|
|400|Bad Request|The request was invalid or cannot be served. The exact error should be explained in the error payload. E.g. „The JSON is not valid“|
|401|Unauthorized|The request requires a user authentication|
|403|Forbidden|The server understood the request but is refusing it or the access is not allowed.|
|404|Not found|There is no resource behind the URI.|
|422|Unprocessable Entity|Should be used if the server cannot process the entity, e.g. if an image cannot be formatted or mandatory fields are missing in the payload.|
|500|Internal Server Error|API developers should avoid this error. If an error occurs in the global catch blog, the stracktrace should be logged and not returned as in the response.|
