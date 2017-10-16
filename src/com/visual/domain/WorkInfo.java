package com.visual.domain;



public class WorkInfo {
	
	private int index;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getFeel() {
		return feel;
	}
	public void setFeel(String feel) {
		this.feel = feel;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public void setId(String string) {
		// TODO Auto-generated method stub
		this.userid=string;
	}
	public String getId(){
		return userid;
	}
	private String name;
	private String work;
	private String feel;
	private String date;
	private String team;
	private String userid;
	
	@Override
	public String toString() {
		return "WorkInfo [index=" + index + ", name=" + name + ",userid="+userid+",work=" + work
				+ ", feel=" + feel + ", date=" + date + ", team=" + team + "]";
	}
	

}
