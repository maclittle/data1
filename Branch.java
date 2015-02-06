package finitesets;

public class Branch implements FiniteSet{
    FiniteSet left;
    int key;
    FiniteSet right;
    
    Branch (FiniteSet left, int key, FiniteSet right) {
        this.left = left;
        this.key = key;
        this.right = right;
    }
    
    public String toString() {
        return "new Branch(" +
                this.left + ", " +
                this.key + ", " +
                this.right + ")";
    }
    
    public FiniteSet empty(){
        return new Leaf();
    }
    
    public int cardinality(FiniteSet t){
        return cardinality(left) + 1 + cardinality(right);
    }
    
    public boolean isEmptyHuh(FiniteSet t){
        return (t == new Leaf());
    }
    
    public boolean member(FiniteSet t, int elt){
        if (key == elt) {
            return true;
        } else if (key > elt) {
            member(left, elt);
        } else {
            member(right, elt); 
        }
    }
    
    public FiniteSet add(FiniteSet t, int elt){
        if (key == elt) {
            return t;
        } else if (key < elt) {
            return new Branch(left.add(t, elt), elt, right);
        } else {
            return new Branch(left, elt, right.add(t, elt));
        }
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