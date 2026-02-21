package com.crm.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String orderDate;
    
    @Column
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(
        name="order_product",
        joinColumns=@JoinColumn(name="order_id"),
        inverseJoinColumns=@JoinColumn(name="product_id")
    )
    private List<Product> products;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public SupportTicket getSupportTicket() {
		return supportTicket;
	}

	public void setSupportTicket(SupportTicket supportTicket) {
		this.supportTicket = supportTicket;
	}

	@OneToOne(mappedBy="order", cascade = CascadeType.ALL)
    private SupportTicket supportTicket;
}