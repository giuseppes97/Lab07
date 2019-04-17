package it.polito.tdp.poweroutages.model;

import java.sql.Date;
import java.time.*;

public class Blackout {
private int id;
private int event_type_id;
private int tag_id;
private int area_id;
private int nerc_id;
private int responsible_id;
private int customers_affected;
private Date date_event_began;
private Date date_event_finished;

public Blackout(int id, int event_type_id, int tag_id, int area_id, int nerc_id, int responsible_id,
		int customers_affected, Date date, Date date2) {
	
	this.id = id;
	this.event_type_id = event_type_id;
	this.tag_id = tag_id;
	this.area_id = area_id;
	this.nerc_id = nerc_id;
	this.responsible_id = responsible_id;
	this.customers_affected = customers_affected;
	this.date_event_began = date;
	this.date_event_finished = date2;
	
}

@Override
public String toString() {
	return "Blackout [id=" + id + ", event_type_id=" + event_type_id + ", tag_id=" + tag_id + ", area_id=" + area_id
			+ ", nerc_id=" + nerc_id + ", responsible_id=" + responsible_id + ", customers_affected="
			+ customers_affected + ", date_event_began=" + date_event_began + ", date_event_finished="
			+ date_event_finished + "]";
}




}
