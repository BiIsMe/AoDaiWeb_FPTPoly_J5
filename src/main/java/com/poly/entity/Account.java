package com.poly.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * The persistent class for the accounts database table.
 * 
 */
@Data
@Entity
@Table(name="accounts")
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotBlank(message="Input username")
	private String username;

	private boolean activated=true;

	@NotBlank(message="Input address")
	private String address;

	private boolean admin=false;

	@NotBlank(message="Input email")
	private String email;

	@NotBlank(message="Input name")
	private String name;

	@NotBlank(message="Nhập password")
	private String password;

	private String phone="000000000";

	//bi-directional many-to-one association to Order
	@JsonIgnore
	@OneToMany(mappedBy="account")
	private List<Order> orders;


	

}