package com.meiken.oldversion;

/**
 * @Author glf
 * @Date 2020/9/24
 */
public class OldGumballMachine {

    final static int SOLD_OUT = 0;//售完
    final static int NO_QUARTER = 1;//没有钱
    final static int HAS_QUARTER = 2;//有了钱
    final static int SOLD = 3;//出售

    int state = SOLD_OUT;
    int count = 0;

    public OldGumballMachine(int count){
        this.count = count;
        if(count > 0){
            state = NO_QUARTER;
        }
    }


    //投币
    public void insertQuarter(){
        if (state == HAS_QUARTER) {
            System.out.println("You can't insert another quarter");
        }else if(state == NO_QUARTER){
            state = HAS_QUARTER;
            System.out.println("You inserted a quarter");
        }else if(state == SOLD_OUT){
            System.out.println("You can't insert a quarter, the machine is sold out");
        }else if(state == SOLD){
            System.out.println("Please wait, we're already giving you a gumball");
        }
    }


    //退币
    public void ejectQuarter(){
        if(state == HAS_QUARTER){
            System.out.println("Quarter retured");
            state = NO_QUARTER;
        }else if(state == NO_QUARTER){
            System.out.println("You haven't inserted a quarter");
        }else if(state == SOLD){
            System.out.println("Sorry, you already turned the crank");
        }else if(state == SOLD_OUT){
            System.out.println("You can't eject,you haven't inserted a quarter yet");
        }
    }

    //摇动手柄
    public void turnCrank(){
        if(state == HAS_QUARTER){
            System.out.println("You turned....");
            state = SOLD;
            dispense();
        }else if(state == NO_QUARTER){
            System.out.println("You haven't inserted a quarter");
        }else if(state == SOLD){
            System.out.println("Turning twice doesn't get you another gumball");
        }else if(state == SOLD_OUT){
            System.out.println("You turned, but there are no gumballs");
        }
    }

    //发放糖果
    public void dispense(){
        if(state == SOLD){
            System.out.println("A gumball comes rolling out the slot");
            count = count -1;
            if(count == 0){
                System.out.println("Ops, out of gumballs!");
                state = SOLD_OUT;
            }else{
                state = NO_QUARTER;
            }
        }else if(state == NO_QUARTER){
            System.out.println("You need to pay first");
        }else if(state == SOLD_OUT){
            System.out.println("No gumball dispensed");
        }else if(state == HAS_QUARTER){
            System.out.println("No gumball dispensed");
        }

    }
}
