package entity;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	private String idUser;
	
	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String CNP;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name = "idAddress")
	private Address address;

	@OneToMany(mappedBy = "user")
	private List<BankAccount> bankAccounts;

	@OneToMany(mappedBy = "user")
	private List<Credit> credits;

	@Column
	private Date birthDate;

	@Column
	private String email;

	@Column
	private String password;


	public User(String firstName, String lastName, String CNP, Address address, Date birthDate, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.CNP = CNP;
		this.address = address;
		this.birthDate = birthDate;
		this.email = email;
		this.password = password;
	}

	public User() {}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String CNP) {
		this.CNP = CNP;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public List<Credit> getCredits() {
		return credits;
	}

	public void setCredits(List<Credit> credits) {
		this.credits = credits;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
