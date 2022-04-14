public abstract class ObservableProperty {
    private ChangeListener listener;
    public void setListener(ChangeListener listener) {
        this.listener= listener;
    }
    protected void fireValueChangedEvent() {
        if (listener != null) {
            listener.changed(this);
        }
    }
    public abstract String getValue();
}