package sem04hw;

import java.util.Date;

class Ticket {

    private static int counter;
    private final int id;
    private final int customerId;
    private final Date date = new Date();
    private final double price;
    private String qrcode;
    private boolean enable = true;

    {
        this.id = ++counter;
    }

    Ticket(int customerId, double price) {
        this.customerId = customerId;
        this.price = price;
        updateQRCode();
    }

    private void updateQRCode() {
        this.qrcode = String.format("ticket_id=%d&customer_id=%d&date=%s", this.id, this.customerId, this.date);
    }

    public int getId() {
        return id;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getQrcode() {
        return qrcode;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Ticket(id = %d, customer ID = %d, date = %s, enabled = %s)",
                this.id, this.customerId, this.date, this.enable);
    }
}
