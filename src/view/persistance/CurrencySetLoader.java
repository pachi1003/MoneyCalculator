package view.persistance;

import model.CurrencySet;

import java.io.IOException;

public interface CurrencySetLoader {
    CurrencySet load() throws IOException;
}
