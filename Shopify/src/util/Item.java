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
    
    

    
	

	public Item(String itemId, String itemName, int price, int quantity, String category, String sleeve,
			String neck_shape, int size, String form, boolean isGoldfilled) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.sleeve = sleeve;
		this.neck_shape = neck_shape;
		this.size = size;
		this.form = form;
		this.isGoldfilled = isGoldfilled;
	}
	
	

	public Item() {
		super();
	}



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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((form == null) ? 0 : form.hashCode());
		result = prime * result + (isGoldfilled ? 1231 : 1237);
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((neck_shape == null) ? 0 : neck_shape.hashCode());
		result = prime * result + price;
		result = prime * result + quantity;
		result = prime * result + size;
		result = prime * result + ((sleeve == null) ? 0 : sleeve.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (form == null) {
			if (other.form != null)
				return false;
		} else if (!form.equals(other.form))
			return false;
		if (isGoldfilled != other.isGoldfilled)
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (neck_shape == null) {
			if (other.neck_shape != null)
				return false;
		} else if (!neck_shape.equals(other.neck_shape))
			return false;
		if (price != other.price)
			return false;
		if (quantity != other.quantity)
			return false;
		if (size != other.size)
			return false;
		if (sleeve == null) {
			if (other.sleeve != null)
				return false;
		} else if (!sleeve.equals(other.sleeve))
			return false;
		return true;
	}




	
	

}
