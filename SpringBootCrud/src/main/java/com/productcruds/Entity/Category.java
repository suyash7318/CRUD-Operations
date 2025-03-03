package com.productcruds.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="CategoryTable")
public class Category 
{	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column(name="Category_Name")
		private String cname;
		
		@OneToMany(mappedBy = "category", cascade=CascadeType.ALL)
		@JsonManagedReference
		private List<Products> products;

		public Category() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Category(int id, String cname) {
			super();
			this.id = id;
			this.cname = cname;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCname() {
			return cname;
		}

		public void setCname(String cname) {
			this.cname = cname;
		}

		public List<Products> getProducts() {
			return products;
		}

		public void setProducts(List<Products> products) {
			this.products = products;
		}
		@Override
		public String toString() {
			return String.valueOf(id);
		}
		
}
