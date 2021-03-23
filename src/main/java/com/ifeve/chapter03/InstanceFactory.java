package com.ifeve.chapter03;

public class InstanceFactory {

    public static class InstanceHolder {

        public static Instance instance = new Instance();
    }

    public static Instance getInstance() {
        return InstanceHolder.instance; //这里将导致InstanceHolder类被初始化
    }

    static class Instance {
    }
}

class A{
    public static void main(String[] args) {
        System.out.println(InstanceFactory.InstanceHolder.instance);;
    }
}
