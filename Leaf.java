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
        return (t == new Leaf());
    }
    
    public boolean member(FiniteSet t, int elt){
        return (t.key == elt);
    }
    
    public FiniteSet add(FiniteSet t, int elt){
        return new Branch(this, elt, this);
    }
    
    public FiniteSet remove(FiniteSet t, int elt){
        
    }
    
    public FiniteSet union(FiniteSet t, FiniteSet u){
        
    }
    
    public FiniteSet inter(FiniteSet t, FiniteSet u){
        
    }
    
    public FiniteSet diff(FiniteSet t, FiniteSet u){
        
    }
    
    public boolean equal(FiniteSet t, FiniteSet u){
        
    }
    
    public boolean subset(FiniteSet t, FiniteSet u){
        
    }
}