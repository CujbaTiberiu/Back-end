package com.EsSpring.day1.godfathersPizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PizzaMargherita {

	private String pomodoro;
	private String mozzarella;
	private Integer calorie;
	private double prezzo;
	
	public void readTxt() {
	 System.out.println("Pizza Margherita" + "(" + getPomodoro() + "," + getMozzarella() + ") "  + getCalorie() + " " + getPrezzo());
	}
}
