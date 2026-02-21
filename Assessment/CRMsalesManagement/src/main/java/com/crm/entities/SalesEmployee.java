package com.crm.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="sales_employee")
public class SalesEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;

    @OneToMany(mappedBy="employee")
    private List<Lead> leads;

    @ManyToMany
    @JoinTable(
        name="employee_product",
        joinColumns=@JoinColumn(name="employee_id"),
        inverseJoinColumns=@JoinColumn(name="product_id")
    )
    private List<Product> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Lead> getLeads() {
		return leads;
	}

	public void setLeads(List<Lead> leads) {
		this.leads = leads;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}