public class BellButton extends ObservableProperty {
    private boolean isPressed= false;
    public void press() {
        isPressed= true;
        fireValueChangedEvent();
    }
    public void release() {
        isPressed= false;
        fireValueChangedEvent();
    }
    @Override public String getValue() {
        if (isPressed) {
            return "pressed";
        } else {
            return "released";
        }
    }
}