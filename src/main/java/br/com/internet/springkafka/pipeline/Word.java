package br.com.internet.springkafka.pipeline;

import java.io.Serializable;

public class Word implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String word;
	private int count;
	
	public Word(String word, int count) {
		super();
		this.word = word;
		this.count = count;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
