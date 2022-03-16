public class BellMain {
    public static void main(String[] args) {
        BellButton btn= new BellButton();
        
        class DoorBell implements ChangeListener {
            public void changed (ObservableProperty observable) {
                System.out.println(observable.getValue());
            }
        }
        
        ChangeListener b = (observable) -> System.out.println(observable.getValue());
        
        btn.setListener(b);
        
        btn.press();
        btn.release();
        btn.press();
        btn.release();
    }
}