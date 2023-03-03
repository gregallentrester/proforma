package net.greg.examples.salient.proforma.model;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "Employee")
public class Employee {

	private long id;
	private String fName;
	private String lName;
	private Date dob;
	private String title;


	public Employee() {  }

	public Employee(
			String firstName, String lastName, Date birthday, String moniker) {

		fName = firstName;
		lName = lastName;
		dob = birthday;
		title = moniker;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() { return id; }
	public void setId(long idVal) { id = idVal; }

	@Column(name = "fname", nullable = false)
	public String getFName() { return fName; }
	public void setFName(String value) { fName = value; }

	@Column(name = "lname", nullable = false)
	public String getLName() { return lName; }
	public void setLName(String value) { lName = value; }

	@Temporal(TemporalType.DATE)
	@Column(name = "dob", nullable = false)
	public Date getDob() { return dob; }
	public void setDob(Date value) { dob = value; }

	@Column(name = "title", nullable = false)
	public String getTitle() { return title; }
	public void setTitle(String value) { title = value; }


	@Override
	public String toString() {
		return
			"Employee [id=" + id +
				", fName=" + fName +
				", lName=" + lName +
				", dob=" + dob +
				", title=" + title + "]";
	}
}
