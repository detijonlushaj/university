class Person {
    private String name;
    private int alter;
    public Person(String name, int alter) {
        this.name= name;
        this.alter= alter;
    }
    public String getName() { 
        return name;
    }
    public int getAlter() { 
        return alter;
    }
    @Override public String toString() {
        return name + " (" + alter +")";
    }
}