package org.rapidpm.demo.chopen2014.pattern.builder;

/**
 * Created by Sven Ruppert on 09.09.2014.
 */
public class Demo {

  private String txt;
  private int counter;

  private Demo(Builder builder) {
    setTxt(builder.txt);
    setCounter(builder.counter);
  }


  public String getTxt() {
    return txt;
  }

  public void setTxt(String txt) {
    this.txt = txt;
  }

  public int getCounter() {
    return counter;
  }

  public void setCounter(int counter) {
    this.counter = counter;
  }

  public static final class Builder {
    private String txt;
    private int counter;

    public Builder() {
    }

    public Builder txt(String txt) {
      this.txt = txt;
      return this;
    }

    public Builder counter(int counter) {
      this.counter = counter;
      return this;
    }

    public Demo build() {
      final Demo demo = new Demo(this);
      demo.counter = this.counter;
      demo.txt = this.txt;

      return demo;
    }
  }
}
