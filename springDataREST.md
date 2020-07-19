Spring Data Rest:

can create CRUD operation with our controller

### ApplicationUser.java:

```
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ApplicationUser {
    @Id
    private int id;
    private String name;
    private String email;
}

```

#### UserRepository.java:

```
@RepositoryRestResource(collectionResourceRel = "users",path = "users")
public interface UserRepository extends PagingAndSortingRepository<ApplicationUser,Integer> {

    public ApplicationUser findByEmail(@Param("email") String email);
}

To Test:

http://localhost:8080/users/search/findByEmail?email=sandy@gmail.com


@RepositoryRestResource(path = "people")
interface PersonRepository extends CrudRepository<Person, Long> {

  @RestResource(path = "names", rel = "names")
  List<Person> findByName(String name);
}

```

#### To test we can define  in springboot starter:

```

@SpringBootApplication
public class SpringDataRestApplication {
	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void init(){
		repository.saveAll(Stream.of(
				new ApplicationUser(101, "Pratik", "p@gmail.com"),
				new ApplicationUser(102, "Dileep", "d@gmail.com"),
				new ApplicationUser(103, "Lav", "l@gmail.com"),
				new ApplicationUser(104, "Swat", "s@gmail.com"))
				.collect(Collectors.toList()));
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
	}

}

```
