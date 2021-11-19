package by.epam.taskfifth.entity;

import java.util.concurrent.Callable;

public class Lorry implements Callable<String> {
    private long lorryId;
    private boolean spoilingProduct;
    public Lorry(long lorryId,boolean spoilingProduct){
        this.lorryId = lorryId;
        this.spoilingProduct = spoilingProduct;
    }

    public long getLorryId() {
        return lorryId;
    }

    public void setLorryId(long lorryId) {
        this.lorryId = lorryId;
    }

    public boolean isSpoilingProduct() {
        return spoilingProduct;
    }

    public void setSpoilingProduct(boolean spoilingProduct) {
        this.spoilingProduct = spoilingProduct;
    }
    @Override
    public String call(){
        LogisticBase base = LogisticBase.getInstance();
        Terminal terminal = base.getAccessToTerminal(this);
        String infoTerminal = String.valueOf(terminal.getTerminalId());
        terminal.serveLorry(this);
        base.releaseTerminal(terminal);
        return "Lorry: "+this.getLorryId() + " Terminal: " +infoTerminal;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lorry)) return false;
        Lorry lorry = (Lorry) o;
        return getLorryId() == lorry.getLorryId() && isSpoilingProduct() == lorry.isSpoilingProduct();
    }
}
