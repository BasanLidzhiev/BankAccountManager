package ru.lidzhiev.bankaccountmanager.request;

public class PutAndWithdrawMoneyRequest {
    int id;
    int sum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
