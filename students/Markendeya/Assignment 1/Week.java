package com.day1;

public class Week {
 private Integer WeekOrderId;
 private String weekDayName;
 
public Week(Integer weekOrderId, String weekDayName) {
	WeekOrderId = weekOrderId;
	this.weekDayName = weekDayName;
}
public Integer getWeekOrderId() {
	return WeekOrderId;
}
public void setWeekOrderId(Integer weekOrderId) {
	WeekOrderId = weekOrderId;
}
public String getWeekDayName() {
	return weekDayName;
}
public void setWeekDayName(String weekDayName) {
	this.weekDayName = weekDayName;
}
@Override
public String toString() {
	return "{WeekOrderId=" + WeekOrderId + ", weekDayName=" + weekDayName + "}";
}
 
}
