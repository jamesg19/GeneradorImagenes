/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrizDispersa;

/**
 *
 * @author willi
 */
public class Nodo {
    private int x;
    private int y;
    private String color;
    private Nodo sigFil, antFil, sigCol, antCol;

    public Nodo(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Nodo(String color, int y, int x, Nodo sigCol, Nodo sigFil) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.sigFil = sigFil;
        this.sigCol = sigCol;
    }

    public Nodo(int x, int y, String color, Nodo sigFil, Nodo antFil, Nodo sigCol, Nodo antCol) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.sigFil = sigFil;
        this.antFil = antFil;
        this.sigCol = sigCol;
        this.antCol = antCol;
    }

    
    
    public Nodo(Nodo sigFil, Nodo antFil, Nodo sigCol, Nodo antCol) {
        this.sigFil = null;
        this.antFil = null;
        this.sigCol = null;
        this.antCol = null;
    }

    public Nodo() {
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Nodo getSigFil() {
        return sigFil;
    }

    public void setSigFil(Nodo sigFil) {
        this.sigFil = sigFil;
    }

    public Nodo getAntFil() {
        return antFil;
    }

    public void setAntFil(Nodo antFil) {
        this.antFil = antFil;
    }

    public Nodo getSigCol() {
        return sigCol;
    }

    public void setSigCol(Nodo sigCol) {
        this.sigCol = sigCol;
    }

    public Nodo getAntCol() {
        return antCol;
    }

    public void setAntCol(Nodo antCol) {
        this.antCol = antCol;
    }
        
    
}
