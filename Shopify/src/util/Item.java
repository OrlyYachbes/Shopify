package util;

public class Item {
    private String itemId;
    private String itemName;
    private int price;
    private int quantity;
    
    private String category;
    private String sleeve;
    private String neck_shape;
    private int size;
    private String form;
    private boolean isGoldfilled;

    
	

	public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSleeve() {
		return sleeve;
	}

	public void setSleeve(String sleeve) {
		this.sleeve = sleeve;
	}

	public String getNeck_shape() {
		return neck_shape;
	}

	public void setNeck_shape(String neck_shape) {
		this.neck_shape = neck_shape;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}
	
	public boolean getIsGoldfilled() {
		return isGoldfilled;
	}

	public void setGoldfilled(boolean isGoldfilled) {
		this.isGoldfilled = isGoldfilled;
	}

}
