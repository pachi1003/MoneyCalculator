package control;


import application.UserSelectedExchange;
import application.ExchangeRateSomeSourceReader;
import application.MoneyResultField;
import model.Exchange;

public class CalculateMoneyCommand implements Command {

    @Override
    public void execute() {
        Exchange exchange = new UserSelectedExchange().load();
        new MoneyResultField(exchange,new ExchangeRateSomeSourceReader(exchange).load()).show();
    }
}
