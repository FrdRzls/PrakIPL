package Tugas;
class Circle extends Shape {
    private float radius;
    private int center;

    public double area(float radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public double circum(float radius) {
        return 2 * Math.PI * radius;
    }

    public void setCenter(int center) {
        this.center = center;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
    }

    @Override
    public void move() {
    }

    @Override
    public void erase() {
    }

    @Override
    public void resize() {
    }
}
