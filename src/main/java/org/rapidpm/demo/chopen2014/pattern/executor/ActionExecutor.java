package org.rapidpm.demo.chopen2014.pattern.executor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sven Ruppert on 09.09.2014.
 */

public abstract class ActionExecutor {

  private List<Action> actionList = new ArrayList<>();

  public void execute(final String txt){
    step01();
    step02();
    doSomething(txt);
  }

  public void addAction(final Action action){
    actionList.add(action);
  }
  public void doSomething(final String txt){
    for (final Action action : actionList) {
      action.doIt(txt);
    }
  }

  public void step02() {
    System.out.println("step02 = ");
  }

  public void step01() {
    System.out.println("step01 = ");
  }

  public abstract static class Action {

    public abstract void doIt(final String txt);
  }


}
