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
        return cardinality(this.left) + 1 + cardinality(this.right);
    }
    
    public boolean isEmptyHuh(FiniteSet t){
        return false;
    }
    
    public boolean member(int elt){
        if (this.key == elt) {
            return true;
        } else if (this.key > elt) {
           return this.left.member(elt);
        } else {
           return this.right.member(elt); 
        }
    }
    
    public FiniteSet add(int elt){
        if (this.key == elt) {
            return this;
        } else if (this.key > elt) {
            return new Branch(this.left.add(elt), elt, this.right);
        } else {
            return new Branch(this.left, elt, this.right.add(elt));
        }
    }
    
    public FiniteSet remove(int elt){
        if (this.key == elt){
           return this.left.union(this.right);
        } else if (this.key > elt){
            return new Branch(this.left.remove(elt), this.key, this.right);
        } else {
            return new Branch(this.left, this.key, this.right.remove(elt));
        } 
    }
    
    public FiniteSet union(FiniteSet u){
       if (!(equal(u))) {
           new Branch(u.add(left.key), u.add(key), u.add(right.key));
       }
    }
    
    public FiniteSet inter(FiniteSet t, FiniteSet u){
       
    }
    
    public FiniteSet diff(FiniteSet u){
        if (this == u) {
            return new Leaf();
        } else if (u.member(this.left.key)){
            u.remove(this.left.key);
        } else if (u.member(this.right.key)) {
            u.remove(this.right.key);
        } else return u;
    }
    
    public boolean equal(FiniteSet u){
        return (this.left == u.left &&
                this.right == u.right &&
                this.key == u.key);

    }
    
    public boolean subset(FiniteSet u){
        if (this == u.left || this == u.right || this == u){
            return true;
        } else if (u.subset(right)) {
            return true;
        } else {
            return u.subset(right);
        }
    }
}