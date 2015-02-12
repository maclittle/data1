package finitesets;

public class Leaf implements FiniteSet {
    
    Leaf () {}
    
    public String toString() {
        return "new leaf()";
    }
    
    public FiniteSet empty(){
        return new Leaf();
    }
    
    public int cardinality(FiniteSet t){
        return 0;
    }
    
    public boolean isEmptyHuh(FiniteSet t){
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
        
    }
    
    public FiniteSet inter(FiniteSet u){
        
    }
    
    public FiniteSet diff(FiniteSet u){
        
    }
    
    public boolean equal(FiniteSet u){
        
    }
    
    public boolean subset(FiniteSet u){
        return false;
    }
}