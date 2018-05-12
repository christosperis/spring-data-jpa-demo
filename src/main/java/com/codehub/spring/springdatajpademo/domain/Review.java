package com.codehub.spring.springdatajpademo.domain;

import com.codehub.spring.springdatajpademo.enums.Rating;
import com.codehub.spring.springdatajpademo.enums.TripType;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Review implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "review_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;

	@Column(nullable = false)
	private int index;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Rating rating;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date checkInDate;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private TripType tripType;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false, length = 5000)
	private String details;

	protected Review() {
	}

	public Review(Hotel hotel, int index, Rating rating, Date checkInDate, TripType tripType, String title, String details) {
		this.hotel = hotel;
		this.index = index;
		this.rating = rating;
		this.checkInDate = checkInDate;
		this.tripType = tripType;
		this.title = title;
		this.details = details;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public int getIndex() {
		return this.index;
	}

	public Rating getRating() {
		return this.rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Date getCheckInDate() {
		return this.checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public TripType getTripType() {
		return this.tripType;
	}

	public void setTripType(TripType tripType) {
		this.tripType = tripType;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
