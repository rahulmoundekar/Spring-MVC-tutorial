package com.app.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="color")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String color;

	@ManyToMany
	@JoinTable(name = "product_color", joinColumns = @JoinColumn(name = "cid"), inverseJoinColumns = @JoinColumn(name = "pid"))
	private List<ProductEntity> products;

}
