public class Node {

    private char value;
    private Node north;
    private Node east;
    private Node south;
    private Node west;


    Node() {

    }


    public char getValue() {
        return value;
    }
    public void setValue(char newVal) {
        value = newVal;
    }

    public Node getNorthNode() {
        return north;
    }
    public Node getEastNode() {
        return east;
    }
    public Node getSouthNode() {
        return south;
    }
    public Node getWestNode() {
        return west;
    }


    public boolean hasNorthNode() {
        if(getNorthNode() == north) {
            return true;
        } else {
            return false;
        }
    }
    public boolean hasEastNode() {
        if(getEastNode() == east) {
            return true;
        } else {
            return false;
        }
    }
    public boolean hasSouthNode() {
        if(getSouthNode() == south) {
            return true;
        } else {
            return false;
        }
    }
    public boolean hasWestNode() {
        if(getWestNode() == west) {
            return true;
        } else {
            return false;
        }
    }






}
