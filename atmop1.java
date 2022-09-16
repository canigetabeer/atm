package atmpack;

import java.util.HashMap;
import java.util.Map;

public class atmop1 implements atmop2 {
    atm at = new atm();
    Map<Double, String> ministmt = new HashMap<>();

    @Override
    public void viewBalance() {
        System.out.println("Available Balance is : " + at.getBalance());

    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if (withdrawAmount % 500 == 0) {
            if (withdrawAmount <= at.getBalance()) {
                ministmt.put(withdrawAmount, " Amount Withdrawn");
                System.out.println("Collect the Cash " + withdrawAmount);
                at.setBalance(at.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance !!");
            }
        } else {
            System.out.println("Please enter the amount in multipal of 500");
        }

    }

    @Override
    public void depositAmount(double depositAmount) {
        ministmt.put(depositAmount, " Amount Deposited");
        System.out.println(depositAmount + " Deposited Successfully !!");
        at.setBalance(at.getBalance() + depositAmount);
        viewBalance();

    }

    @Override
    public void viewMiniStatement() {
        for (Map.Entry<Double, String> m : ministmt.entrySet()) {
            System.out.println(m.getKey() + "" + m.getValue());
        }

    }
}
