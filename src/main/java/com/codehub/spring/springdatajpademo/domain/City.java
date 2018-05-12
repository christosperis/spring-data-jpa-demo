package com.codehub.spring.springdatajpademo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "city_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String state;

	@Column(nullable = false)
	private String country;

	@Column(nullable = false)
	private String map;

	protected City() {
	}

	public City(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return this.name;
	}

	public String getState() {
		return this.state;
	}

	public String getCountry() {
		return this.country;
	}

	public String getMap() {
		return this.map;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("City{");
		sb.append("id=").append(id);
		sb.append(", name='").append(name).append('\'');
		sb.append(", state='").append(state).append('\'');
		sb.append(", country='").append(country).append('\'');
		sb.append(", map='").append(map).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
