public class Accessory {
    private String name;
    private String price;
    private String imagePath;

    // Constructor
    public Accessory(String name, String price, String imagePath) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getImagePath() {
        return imagePath;
    }

    // Override toString method for displaying accessory details in the checkout window
    @Override
    public String toString() {
        return name + " - " + price;
    }

}
