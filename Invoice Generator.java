*InvoiceGenerator.java*
```
import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceGenerator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to Invoice Generator!");

    // Get user input
    System.out.print("Enter invoice number: ");
    int invoiceNumber = scanner.nextInt();
    System.out.print("Enter date (yyyy-mm-dd): ");
    String date = scanner.next();
    System.out.print("Enter bill-to name: ");
    String billToName = scanner.next();
    System.out.print("Enter bill-to address: ");
    String billToAddress = scanner.next();
    System.out.print("Enter ship-to name: ");
    String shipToName = scanner.next();
    System.out.print("Enter ship-to address: ");
    String shipToAddress = scanner.next();

    // Get items
    ArrayList<Item> items = new ArrayList<>();
    while (true) {
      System.out.print("Enter item description (or 'done' to finish): ");
      String itemDescription = scanner.next();
      if (itemDescription.equalsIgnoreCase("done")) {
        break;
      }
      System.out.print("Enter quantity: ");
      int quantity = scanner.nextInt();
      System.out.print("Enter unit price: ");
      double unitPrice = scanner.nextDouble();
      items.add(new Item(itemDescription, quantity, unitPrice));
    }

    // Generate invoice
    Invoice invoice = new Invoice(invoiceNumber, date, billToName, billToAddress, shipToName, shipToAddress, items);
    System.out.println("Invoice Generated:");
    System.out.println(invoice.toString());
  }
}

class Item {
  private String description;
  private int quantity;
  private double unitPrice;

  public Item(String description, int quantity, double unitPrice) {
    this.description = description;
    this.quantity = quantity;
    this.unitPrice = unitPrice;
  }

  public double getTotal() {
    return quantity * unitPrice;
  }

  public String toString() {
    return description + " x " + quantity + " = " + getTotal();
  }
}

class Invoice {
  private int invoiceNumber;
  private String date;
  private String billToName;
  private String billToAddress;
  private String shipToName;
  private String shipToAddress;
  private ArrayList<Item> items;

  public Invoice(int invoiceNumber, String date, String billToName, String billToAddress, String shipToName, String shipToAddress, ArrayList<Item> items) {
    this.invoiceNumber = invoiceNumber;
    this.date = date;
    this.billToName = billToName;
    this.billToAddress = billToAddress;
    this.shipToName = shipToName;
    this.shipToAddress = shipToAddress;
    this.items = items;
  }

  public double getTotal() {
    double total = 0;
    for (Item item : items) {
      total += item.getTotal();
    }
    return total;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Invoice #").append(invoiceNumber).append("\n");
    sb.append("Date: ").append(date).append("\n");
    sb.append("Bill To: ").append(billToName).append("\n");
    sb.append("Address: ").append(billToAddress).append("\n");
    sb.append("Ship To: ").append(shipToName).append("\n");
    sb.append("Address: ").append(shipToAddress).append("\n");
    sb.append("Items:\n");
    for (Item item : items) {
      sb.append("  ").append(item.toString()).append("\n");
    }
    sb.append("Total: ").append(getTotal()).append("\n");
    return sb.toString();
  }
}
```
