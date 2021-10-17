package com.adamfgcross.javanotes;

public class MyImmutableObject {
    private Integer max;
    private Integer min;


    public static class Builder {
        private Integer max;
        private Integer min;
        public Builder() {
        }
        Builder max(Integer max) {
            this.max = max;
            return this;
        }
        Builder min(Integer min) {
            this.min = min;
            return this;
        }
        MyImmutableObject build () {
            return new MyImmutableObject(min, max);
        }
    }


    public static MyImmutableObject of (int min, int max) {
        MyImmutableObject myImmutableObject = new MyImmutableObject();
        myImmutableObject.max = max;
        myImmutableObject.min = min;
        return myImmutableObject;
    }

    private MyImmutableObject(Integer max, Integer min) {
        this.max = max;
        this.min = min;
    }

    private MyImmutableObject(){

    }
}
