package examptions;

import data.BrowserData;

import java.util.Locale;

public class BrowserNotFoundException extends Exception{

    public BrowserNotFoundException(BrowserData browserData){
        super(String.format("Browser %s not found", browserData.name()).toLowerCase(Locale.ROOT));
    }

}
