class Bank {
    protected double transactionCharges = 50.0;

    public double calculateTransactionCharges(double transactionAmount) {
        return transactionCharges;
    }
}

class ICICI extends Bank {

    public ICICI() {
        this.transactionCharges = 30.0;
    }

    @Override
    public double calculateTransactionCharges(double transactionAmount) {
        return transactionCharges;
    }
}

class HDFC extends Bank {

    public HDFC() {
        this.transactionCharges = 40.0;
    }

    @Override
    public double calculateTransactionCharges(double transactionAmount) {
        return transactionCharges;
    }
}

public class BankTransaction {
    public static void main(String[] args) {
        double transactionAmount = 1000.0;

        Bank iciciBank = new ICICI();
        Bank hdfcBank = new HDFC();

        double iciciCharges = iciciBank.calculateTransactionCharges(transactionAmount);
        double hdfcCharges = hdfcBank.calculateTransactionCharges(transactionAmount);

        System.out.println("Transaction Amount: " + transactionAmount);
        System.out.println("ICICI Bank Transaction Charges: " + iciciCharges);
        System.out.println("HDFC Bank Transaction Charges: " + hdfcCharges);

        double iciciTotalAmount = transactionAmount + iciciCharges;
        double hdfcTotalAmount = transactionAmount + hdfcCharges;

        System.out.println("Total Amount to be paid at ICICI: " + iciciTotalAmount);
        System.out.println("Total Amount to be paid at HDFC: " + hdfcTotalAmount);
    }
}
