package application;

import model.Currency;
import model.Exchange;
import model.Money;
import view.persistance.ExchangeRateLoader;

import javax.swing.*;

import static application.Application.components;
import static application.Application.currencySet;

public class UserSelectedExchange implements ExchangeRateLoader {
    @Override
    public Exchange load() {
        return new Exchange(new Money(currencyFrom(), amount()), currencyTo());
    }

    public Currency currencyFrom() {
        try{
            return  currencySet().findCurrencyInCurrencySetByCode(((JComboBox) components().get("OriginalCombo")).getSelectedItem().toString());
        }catch (Exception e){
            return null;
        }
    }

    public double amount() {
        try {
            return Double.parseDouble(((JTextField) components().get("OriginalMoneyTextField")).getText());
        }catch (Exception e){
            return 0;
        }
    }

    public Currency currencyTo() {
        try {
            return currencySet().findCurrencyInCurrencySetByCode(((JComboBox) components().get("ExchangeToCombo")).getSelectedItem().toString());
        }catch (Exception e){
            return null;
        }
    }
}
