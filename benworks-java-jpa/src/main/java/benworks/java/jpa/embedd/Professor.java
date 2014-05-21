package benworks.java.jpa.embedd;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "EMP")
@SecondaryTable(name = "EMP_ADDRESS", pkJoinColumns = @PrimaryKeyJoinColumn(name = "EMP_ID"))
public class Professor {
	@Id
	private int id;
	private String name;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(table = "EMP_ADDRESS")),
		@AttributeOverride(name = "city", column = @Column(name = "CITY", table = "EMP_ADDRESS")),
		@AttributeOverride(name = "state", column = @Column(name = "STATE", table = "EMP_ADDRESS")),
		@AttributeOverride(name = "zip", column = @Column(name = "ZIP_CODE", table = "EMP_ADDRESS")) })
	private Address address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String toString() {
		return "Professor id: " + getId() + " name: " + getName() + " with " + getAddress();
	}
}