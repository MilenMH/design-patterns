package decorator.and.facade.core;

import decorator.and.facade.decorator.GetIngredients;

import java.util.Arrays;

public class Hamburger implements GetIngredients {

    private String upperSliceOfBread;

    private String lowerSliceOfBread;

    private String meatball;

    private String lettuce;

    public Hamburger(String upperSliceOfBread, String lowerSliceOfBread, String meatball, String lettuce) {
        this.upperSliceOfBread = upperSliceOfBread;
        this.lowerSliceOfBread = lowerSliceOfBread;
        this.meatball = meatball;
        this.lettuce = lettuce;
    }

    public String getUpperSliceOfBread() {
        return upperSliceOfBread;
    }

    public void setUpperSliceOfBread(String upperSliceOfBread) {
        this.upperSliceOfBread = upperSliceOfBread;
    }

    public String getLowerSliceOfBread() {
        return lowerSliceOfBread;
    }

    public void setLowerSliceOfBread(String lowerSliceOfBread) {
        this.lowerSliceOfBread = lowerSliceOfBread;
    }

    public String getMeatball() {
        return meatball;
    }

    public void setMeatball(String meatball) {
        this.meatball = meatball;
    }

    public String getLettuce() {
        return lettuce;
    }

    public void setLettuce(String lettuce) {
        this.lettuce = lettuce;
    }

    @Override
    public String[] getIngredients() {
        return new String[]{this.getUpperSliceOfBread(), this.getLettuce(), this.getMeatball(), this.getLowerSliceOfBread()};
    }
}
