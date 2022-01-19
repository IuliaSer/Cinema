package edu.school21.cinema.models;


import javax.persistence.*;

@Entity
@Table(name = "halls")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="serialNum")
    private int serialNum;

    @Column(name="amountOfSeats")
    private int amountOfSeats;

    public Hall(int serialNum, int amountOfSeats) {
        this.serialNum = serialNum;
        this.amountOfSeats = amountOfSeats;
    }

    public Hall() {

    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public int getAmountOfSeats() {
        return amountOfSeats;
    }

    public void setAmountOfSeats(int amountOfSeats) {
        this.amountOfSeats = amountOfSeats;
    }
}
