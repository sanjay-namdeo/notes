## get() vs load()

|get()|load()|
|---|---|
|It loads the data when it is called|It returns a proxy object and loads data only when it's actually required. Load supports lazy loading|
|get() doesn't throw an exception when data is not found|Load throws execption when data is not found|
|get() loads the data as soon as it’s called|load() returns a proxy object and loads data only when it’s actually required, so load() is better because it support lazy loading|
|We should use get() when we want to make sure data exists in the database|Since load() throws exception when data is not found, we should use it only when we know data exists|

