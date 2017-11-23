package wp.model;
// Class dùng để mô hình hóa các dữ liệu trong bài
public class GuestBookEntry {
	private String name;
	private String message;
	private int key;
	
	public GuestBookEntry() {
		
	} 
	
	public GuestBookEntry(String name, String message, int key) {
		this.name=name;
		this.message=message;
		this.key= key;
	}
	//get va set cac gia tri private de cac lop khac truy xuat toi name, message

	public String getName() {
		return name ;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
}
