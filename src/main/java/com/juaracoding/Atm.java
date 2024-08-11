package com.juaracoding;

public class Atm {
    private double saldo;

    // Konstruktor untuk menginisialisasi saldo awal
    public Atm(double saldoAwal) {
        if (saldoAwal < 0) {
            throw new IllegalArgumentException("Saldo awal tidak bisa negatif.");
        }
        this.saldo = saldoAwal;
    }

    // Mengembalikan saldo saat ini
    public double lihatSaldo() {
        return saldo;
    }

    // Menambah saldo dengan jumlah yang diberikan jika valid
    public void setorUang(double jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah setor harus lebih besar dari 0.");
        }
        saldo += jumlah;
    }

    // Mengurangi saldo dengan jumlah yang diberikan jika valid
    public void tarikUang(double jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah tarik harus lebih besar dari 0.");
        }
        if (jumlah > saldo) {
            throw new IllegalArgumentException("Saldo tidak mencukupi untuk penarikan.");
        }
        saldo -= jumlah;
    }
}