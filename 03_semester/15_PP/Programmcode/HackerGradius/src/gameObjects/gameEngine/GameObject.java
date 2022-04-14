package gameObjects.gameEngine;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
/**
 * This creates the GameObject which is every object in the game
 * */
public class GameObject extends Rectangle{

    public Vector position;
    public Vector velocity;
    public double rotation;
    public Rectangle boundary;
    public Image image;
    public double elapseTime; //Sekunden

    //Default constructor
    public GameObject(){
        this.position = new Vector();
        this.velocity = new Vector();
        this.rotation = 0;
        this.boundary = new Rectangle();
        this.elapseTime = 0;
    }

    //Constructor with File input (image)
    public GameObject(String imageFileName) {
        this();
        setImage(imageFileName);
    }

    //Setter for image
    public void setImage(String imageFileName) {
        this.image = new Image(imageFileName);
        this.boundary.setSize(this.image.getWidth(),this.image.getHeight());
    }

    //getter for Boundary
    public Rectangle getBoundary() {
        this.boundary.setPosition(this.position.x, this.position.y);
        return this.boundary;
    }

    //looks if it overlaps with an other object
    public boolean overlaps(GameObject other) {
        return this.getBoundary().overlaps(other.getBoundary());
    }

    //updates the position
    public void update(double deltatime) {
        this.elapseTime += deltatime;
        this.position.add(this.velocity.x * deltatime, this.velocity.y * deltatime);
    }

    //rendered the object
    public void render(GraphicsContext context) {
        context.save();

        context.translate(this.position.x,this.position.y);
        context.rotate(this.rotation);
        context.translate(-this.image.getWidth()/2,-this.image.getHeight()/2);
        context.drawImage(this.image,0,0);

        context.restore();
    }

    public Vector getPosition() {
        return this.position;
    }
}
