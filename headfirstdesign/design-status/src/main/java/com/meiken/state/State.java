package com.meiken.state;

/**
 * @Author glf
 * @Date 2020/9/24
 */
public interface State {

    public void insertQuarter();

    public void ejectQuarter();

    public void turnCrank();

    public void dispense();
}
