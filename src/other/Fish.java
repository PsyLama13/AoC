package other;

public class Fish {
    boolean caught;
    boolean free;
    int position;
    Color color;

    public Fish(int position, Color color) {
        this.position = position;
        this.color = color;
        caught = false;
        free = false;
    }

    public boolean isCaught() {
        return caught;
    }

    public void setCaught(boolean caught) {
        this.caught = caught;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
