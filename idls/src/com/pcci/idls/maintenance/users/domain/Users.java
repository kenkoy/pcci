package com.pcci.idls.maintenance.users.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Users {
	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", length = 20, nullable = false)
    private String id;

    @Column(name = "PWORD", length = 256, nullable = false)
    private String password;

    @Column(name = "ROLE_ID", length = 10, nullable = false)
    private String roleId;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;
    
    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstName;
    
    @Column(name = "MIDDLE_NAME", length = 50, nullable = false)
    private String middleName;
    
    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;
    
    @Column(name = "PHONE", length = 20, nullable = false)
    private String phone;
    
    @Column(name = "EFFECTIVE_DATE", nullable = false)
    private Date effDate;

    @Column(name = "EXPIRY_DATE", nullable = false)
    private Date expDate;

    @Column(name = "PWORD_EFFECTIVE_DATE", nullable = false)
    private Date pwEffDate;

    @Column(name = "LAST_LOG_ON", nullable = false)
    private Date lastLogOn;
    
    @Column(name = "LAST_UPDATE", nullable = false)
    private Date lastUpdate;

    @Column(name = "MODIFIED_BY", length = 20, nullable = false)
    private String modifiedBy;

    @Column(name = "LOCKED", length = 1, nullable = false)
    private int locked;
    
    public Users() {}

	public Users(String id, String password, String roleId, String lastName,
			String firstName, String middleName, String email, String phone,
			Date effDate, Date expDate, Date pwEffDate, Date lastLogOn,
			Date lastUpdate, String modifiedBy, int locked) {
		super();
		this.id = id;
		this.password = password;
		this.roleId = roleId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.email = email;
		this.phone = phone;
		this.effDate = effDate;
		this.expDate = expDate;
		this.pwEffDate = pwEffDate;
		this.lastLogOn = lastLogOn;
		this.lastUpdate = lastUpdate;
		this.modifiedBy = modifiedBy;
		this.locked = locked;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public Date getPwEffDate() {
		return pwEffDate;
	}

	public void setPwEffDate(Date pwEffDate) {
		this.pwEffDate = pwEffDate;
	}

	public Date getLastLogOn() {
		return lastLogOn;
	}

	public void setLastLogOn(Date lastLogOn) {
		this.lastLogOn = lastLogOn;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}

	
	
	
}
