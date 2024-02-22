package Exercise2;

interface DiscountRate {
    double getServiceMemberDiscount();
    double getProductMemberDiscount();
}


class Customer implements DiscountRate{
    private String customerName;
    private String customerType;

    public Customer(String customerName, String customerType) {
        this.customerName = customerName;
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }


    public double getServiceMemberDiscount() {
        switch (customerType) {
            case "Premium":
                return 0.20;
            case "Gold":
                return 0.15;
            case "Silver":
                return 0.10;
            case "Normal":
                return 0.0;
            default:
                return 0;
        }
    }


    public double getProductMemberDiscount() {
        switch (customerType) {
            case "Premium":
                return 0.10;
            case "Gold":
                return 0.10;
            case "Silver":
                return 0.10;
            case "Normal":
                return 0.0;
            default:
                return 0;
        }
    }
}


class Sale {
    private Customer customer;
    private String date;
    private double serviceExpense;
    private double productExpense;

    public Sale(Customer customer, String date) {
        this.customer = customer;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double getTotalExpense() {
        double serviceDiscount = customer.getServiceMemberDiscount() * serviceExpense;
        double productDiscount = customer.getProductMemberDiscount() * productExpense;
        double totalDiscount = serviceDiscount + productDiscount;

        double discountedServiceExpense = serviceExpense - serviceDiscount;
        double discountedProductExpense = productExpense - productDiscount;

        System.out.println("Discount: " + totalDiscount);
        return discountedServiceExpense + discountedProductExpense;
    }

    public void displayInfo() {

        System.out.println("Customer: " + customer.getCustomerName());
        System.out.println("Date: " + date);
        System.out.println("Service Expense: " + serviceExpense);
        System.out.println("Product Expense: " + productExpense);
        System.out.println("Total Expense: " + getTotalExpense());
    }
}


public class ShoppingClass {
    public static void main(String[] args) {

        Customer customer1 = new Customer("Tom Holland", "Premium");
        Customer customer2 = new Customer("Andrew Garfield", "Silver");

        Sale sale1 = new Sale(customer1, "2024-02-22");
        sale1.setServiceExpense(100.0);
        sale1.setProductExpense(50.0);
        sale1.displayInfo();


        Sale sale2 = new Sale(customer2, "2024-02-20");
        sale2.setServiceExpense(120.0);
        sale2.setProductExpense(67.0);
        sale2.displayInfo();
    }
}

