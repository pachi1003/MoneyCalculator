package application;

import model.Exchange;
import model.ExchangeRate;
import model.Money;
import view.UI.MoneyDisplay;

import javax.swing.*;

import static application.Application.components;

public class MoneyResultField implements MoneyDisplay{
    private Exchange exchange;
    private ExchangeRate exchangeRate;

    public MoneyResultField(Exchange exchange, ExchangeRate exchangeRate) {
        this.exchange = exchange;
        this.exchangeRate = exchangeRate;
    }

    @Override
    public void show() {
        ((JTextField) components().get("ResultTextField")).setText(new Money(exchange.currencyTo(),exchange.moneyFrom().amount()*exchangeRate.rate()).toString());
        components().get("ResultTextField").repaint();
    }
}
