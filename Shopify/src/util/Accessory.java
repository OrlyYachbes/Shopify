package util;

public class Accessory extends Item {
    private boolean isGoldFilled;

    public boolean isGoldFilled() {
        return isGoldFilled;
    }

    public void setGoldFilled(boolean goldfilled) {
        isGoldFilled = goldfilled;
    }
}
