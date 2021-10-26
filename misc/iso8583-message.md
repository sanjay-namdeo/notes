# ISO 8583 nucleus
nucleus8583 provides API to read and write from/to ISO-8583 messages. Before using the read/write operation, you will need to create a message factory configuration.

## Message Factory
Message factory is a set of rules defined how to perform conversion to/from ISO-8583 message. These rules are defined in specific XML format:

## encoding
What type of encoding is used in the conversion. Currently only support ASCII.

## iso-message
It can have one or more iso-field tag

## iso-field 
It is used to configure one iso field. So if there are 129 fields in an iso-8583 message, 129 iso-field tags are defined under the iso-package tag

## id
This attribute is intended to determine which bit you want to configure. For example, <iso-field id="4" /> means that tag is intended to configure iso field number 4

## length
This attribute is intended to determine how long the field is. For example, <iso-field id="4" length="12" /> means iso field number 4 has 12 character length

## type 
This attribute is used to determine the type of iso field. For example, <iso-field id="4" length="12" type="n" /> means iso field number 4 has data element type n. Further info about the iso data elements can be found in ISO 8583 - Wikipedia. In the 2.2.0 version, nucleus8583 only supports a, n, s, an, as, ns, ans, b, ., .., and ...

## align
This attribute is used to set how field value is aligned. This attribute has three possible values:
1. **left**: It means the value will be left-aligned, for example, if the field length is 12 but the value set is 3 character length, in the write operation, the field value will be 3 characters of value + 9 padding characters. In the read operation, 12 characters field value will be right trimmed so the 9 padding characters will be ignored resulting in only 3 characters of value.
2. **right**: It means the value will be right-aligned, for example, if the field length is 12 but the value set is 3 character length, in the write operation, the field value will be 9 padding characters + 3 characters of value. In the read operation, 12 characters field value will be left trimmed so the 9 padding characters will be ignored resulting in only 3 characters of value.
3. **none**: It means the value will not be aligned, for example, if the field length is 12 but the value set is 3 character length, in the write operation, the field value will be 3 characters of value + 9 space characters. In the read operation, the 12 characters field value will not be trimmed so no character will be ignored resulting in the 12 characters with no change.

For example, means iso field number 4 has 12 character length and left aligned-
```xml
<iso-field id="4" length="12" align="left" />
```


## pad-with
This attribute is used to specify what character will be used in padding operations. This attribute only allows one character of the string. The padding operation itself has been explained in the align attribute above.

## empty-value 
When a bit value is fully trimmed, it will result in an empty string value. By specifying this attribute, you can replace the empty string value with any other values you want. For example, you specify empty-value="abcd" in iso field number 4. If field number 4 is activated and has an empty string, the field number 4 will have value abcd instead of an empty string.
