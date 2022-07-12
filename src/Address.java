public class Address implements Cloneable{
    private String name;
    @Override
    public Address clone(){
        try {
            return (Address) super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }
}
