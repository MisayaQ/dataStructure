package com.atguigu.enumerate;

public enum Signal {
    //定义一个枚举类型
    GREEN,YELLOW,RED
}

class TrafficLight {
    //    Signal color=Signal.RED;\
    public Signal color;

    public void change() {
        switch (color) {
            case RED:
                color = Signal.RED;
                System.out.println(color);
                break;
            case GREEN:
                color = Signal.GREEN;
                System.out.println(color);
                break;
            case YELLOW:
                color = Signal.YELLOW;
                System.out.println(color);
                break;
        }
    }

    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.color = Signal.YELLOW;
        trafficLight.change();
    }
}
