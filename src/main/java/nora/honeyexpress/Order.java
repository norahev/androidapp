package nora.honeyexpress;

public class Order {
    String _name;
    String _contact;
    String _address;
    String _request;
    String _type;
    int _quantity;
    public Order(String name, String contact, String address, String request, String type, int quantity) {
        this._name = name;
        this._contact = contact;
        this._address = address;
        this._request = request;
        this._type = type;
        this._quantity = quantity;
    }
    public int get_quantity() { return this._quantity; }
    public void set_quantity(int quantity) { this._quantity = quantity; }
    public String get_name() { return this._name; }
    public void set_name(String name) { this._name = name; }
    public String get_contact() { return this._contact; }
    public void set_contact(String contact) { this._contact = contact; }
    public String get_address() { return this._address; }
    public void set_address(String address) { this._address = address; }
    public String get_request() { return this._request; }
    public void set_request(String request) { this._request = request; }
    public String get_type() { return this._type; }
    public void set_type(String type) { this._type = type; }
}
