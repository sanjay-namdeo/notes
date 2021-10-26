## Hibernate Annotations

1. **javax.persistence.Entity** Used with Model classes to specify them as Entity beans
2. **javax.persistence.Table** Used with Entity beans to define corresponding table names in database
3. **javax.persistence.Access** Used to define the access type, either fields or property. Default valus is field and if you want hibernate to use getter/setter methods, then you need to set it to property. E.g. 
@Access(value=AccessType.PROPERTY)
4. **javax.persistence.Id** Used to define the primary key in the Entity bean.
5. **javax.persistence.EmbeddedId** Used to define composite primary key in entity bean
6. **javax.persistence.Column** Used to define the column name in database table.
7. **javax.persistence.GeneratedValue** Used to define the strategy to be used for generation of primary key.
```java
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
```

### Relations
1. **javax.persistence.OneToOne**
2. **javax.persistence.OneToMany**
3. **javax.persistence.ManyToOne**
4. **javax.persistence.ManyToMany**
5. **org.hibernate.annotation.Cascade**
