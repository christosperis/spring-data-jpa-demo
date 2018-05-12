package com.codehub.spring.springdatajpademo.transfer;

import com.codehub.spring.springdatajpademo.domain.City;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class HotelSummary implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final MathContext MATH_CONTEXT = new MathContext(2,
            RoundingMode.HALF_UP);

    private final City city;

    private final String name;

    private final Double averageRating;

    private final Integer averageRatingRounded;

    public HotelSummary(City city, String name, Double averageRating) {
        this.city = city;
        this.name = name;
        this.averageRating = averageRating == null ? null : new BigDecimal(averageRating,
                MATH_CONTEXT).doubleValue();
        this.averageRatingRounded = averageRating == null ? null : (int) Math
                .round(averageRating);
    }

    public City getCity() {
        return this.city;
    }

    public String getName() {
        return this.name;
    }

    public Double getAverageRating() {
        return this.averageRating;
    }

    public Integer getAverageRatingRounded() {
        return this.averageRatingRounded;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HotelSummary{");
        sb.append("city=").append(city);
        sb.append(", name='").append(name).append('\'');
        sb.append(", averageRating=").append(averageRating);
        sb.append(", averageRatingRounded=").append(averageRatingRounded);
        sb.append('}');
        return sb.toString();
    }
}
