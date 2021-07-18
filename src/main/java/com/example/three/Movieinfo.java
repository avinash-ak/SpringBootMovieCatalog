package com.example.three;

public class Movieinfo {
	private String movieId;
	private String name;
	public Movieinfo() {
		super();
	}
	public String getMovieId() {
		return movieId;
	}
	public Movieinfo(String movieId, String name) {
		super();
		this.movieId = movieId;
		this.name = name;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
