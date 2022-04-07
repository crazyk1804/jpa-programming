package net.crazyk.jpa.chapter04.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="MEMBER4", uniqueConstraints={
	@UniqueConstraint(name="NAME_AGE_UNIQUE", columnNames={"NAME", "AGE"})
})
public class Member4 {
	@Id
	@Column(name="ID")
	private String id;
	@Column(name="NAME", nullable=false, length=15)
	private String username;
	@Column(name="age")
	private int age;

	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	@Lob
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
