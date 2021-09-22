package com.jpa.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="customer_master")
@NamedQuery(name="Customer.findByAmount",query="select c from Customer c,Transaction t where t.amount=?1")
public class Customer implements Serializable {
	private static final long serialVersionUID = -7496362624106858939L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int custId;
	@NotNull
	//@Size(min = 2,max = 20, message = "Customer name is required and must be between 2 to 20 chars")
	@Column(name ="name", nullable=false)
	private String custName;
	private String address;
	private String email;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Transaction> transaction = new HashSet<>();
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Transaction> getTransaction() {
		return transaction;
	}
	public void setTransaction(Set<Transaction> transaction) {
		this.transaction = transaction;
		for(Transaction trans:transaction) {
			trans.setCustomer(this);
		}
	}
}