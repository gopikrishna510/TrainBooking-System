package com.booking.app.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Train implements Serializable
{ 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name ="TRAIN_NO" , nullable=false)
	private int trainNo;
	
	@NotNull
	@Length(min =3 , max = 30 ,message ="Name should contain char between 3 and 30")
	@Column(name ="TRAIN_NAME")
	private String trainName; 
	
	@Column(name ="TRAIN_TYPE")
	private String trainType;
	
	@NotEmpty(message = " ")
	@Column(name ="TRAIN_FARE")
	private double trainFare;

	@Column(name ="STARTING_POINT")
	private String stratingPoint;
	
	@Column(name ="DESTINATION_POINT")
	private String destinationPoint;
	


	public Train() {
		super();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainType() {
		return trainType;
	}

	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}

	public double getTrainFare() {
		return trainFare;
	}

	public void setTrainFare(double trainFare) {
		this.trainFare = trainFare;
	}

	public String getStratingPoint() {
		return stratingPoint;
	}

	public void setStratingPoint(String stratingPoint) {
		this.stratingPoint = stratingPoint;
	}

	public String getDestinationPoint() {
		return destinationPoint;
	}

	public void setDestinationPoint(String destinationPoint) {
		this.destinationPoint = destinationPoint;
	}

	@Override
	public String toString() {
		return "Train [id=" + id + ", trainNo=" + trainNo + ", trainName=" + trainName + ", trainType=" + trainType
				+ ", trainFare=" + trainFare + ", stratingPoint=" + stratingPoint + ", destinationPoint="
				+ destinationPoint + "]";
	}
	
	
	//this will used to store date in db
//	@Temporal(TemporalType.TIME)
//	@Column(name="ARRIVAL_TIME")
//	private Date timeOfArrival;
//
//	@Temporal(TemporalType.TIME)
//	@Column(name="Departure_TIME")
//	private Date timeOfDeparture;
	

}
