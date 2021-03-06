package data1;

public class Leaf implements FiniteSet {
    
    Leaf () {}
    
    public String toString() {
        return "new leaf()";
    }
    
    public FiniteSet empty(){
        return new Leaf();
    }
    
    public int cardinality(){
        return 0;
    }
    
    public boolean isEmptyHuh(){
        return true;
    }
    
    public boolean member(int elt){
        return false;
    }
    
    public FiniteSet add(int elt){
        return new Branch(this, elt, this);
    }
    
    public FiniteSet remove(int elt){
        return new Leaf();
    }
    
    public FiniteSet union(FiniteSet u){
        return u;
    }
    
    public FiniteSet inter(FiniteSet u){
        return new Leaf();
    }
    
    public FiniteSet diff(FiniteSet u){
        return u;
    }
    
    public boolean equal(FiniteSet u){
        return u.isEmptyHuh();
    }
    
    public boolean subset(FiniteSet u){
        return true;
    }
}