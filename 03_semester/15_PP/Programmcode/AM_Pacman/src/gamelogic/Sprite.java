package gamelogic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Sprite {
   
    private Vector position;
    private Vector velocity;
    private Image image;
    private Rectangle boundary;
    private int req_dx = 0;
    private int req_dy = 0;
    
    public Sprite() {
        this.position = new Vector(0,0);
        this.velocity = new Vector(0,0);
        this.boundary = new Rectangle(0,0,0,0);
    }
    
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public void setBoundary(Rectangle boundary) {
        this.boundary = boundary;
    }

    public int getReq_dx() {
        return req_dx;
    }

    public void setReq_dx(int req_dx) {
        this.req_dx = req_dx;
    }

    public int getReq_dy() {
        return req_dy;
    }

    public void setReq_dy(int req_dy) {
        this.req_dy = req_dy;
    }

    public void setPosition(int x, int y) {
        this.position.set(x, y);
    }
    
    public void setImage(String filename) {
        this.image = new Image(filename);
        this.boundary.setWidth(this.image.getWidth());
        this.boundary.setHeight(this.image.getHeight());
        
    }
    
    public Rectangle getBoundary() {
        this.boundary.setX(this.position.getX());
        this.boundary.setY(this.position.getY());
        return this.boundary;
    }
    
    public Vector getVelocity() {
        return this.velocity;
    }
    
    public Vector getPosition() {
        return this.position;
    }
    
    /* returns true if this sprite overlaps the other sprite */
    public boolean overlaps(Sprite other) {
        return this.getBoundary().overlaps(other.getBoundary());
    }
    
    public void render(GraphicsContext context) {
        context.drawImage(this.image, this.position.getX(), this.position.getY());
    }
    
    protected boolean checkIfWall(short ch) {
        if ((this.getReq_dx() == -1 && this.getReq_dy() == 0 && (ch & 1) != 0)
                || (this.getReq_dx() == 1 && this.getReq_dy() == 0 && (ch & 4) != 0)
                || (this.getReq_dx()== 0 && this.getReq_dy() == -1 && (ch & 2) != 0)
                || (this.getReq_dx() == 0 && this.getReq_dy() == 1 && (ch & 8) != 0)) {
            return true;
        } else {
            return false;
        }
    } 

}