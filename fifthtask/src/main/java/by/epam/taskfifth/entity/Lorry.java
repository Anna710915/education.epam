package by.epam.taskfifth.entity;

import java.util.concurrent.Callable;

public class Lorry implements Callable<String> {
    private long lorryId;
    private boolean spoilingProduct;
    private boolean upload;
    private int size;
    private int products;

    public Lorry(long lorryId,boolean spoilingProduct, boolean upload,int products,int size ){
        this.lorryId = lorryId;
        this.spoilingProduct = spoilingProduct;
        this.upload = upload;
        this.products = products;
        this.size = size;
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

    public boolean isUpload() {
        return upload;
    }

    public void setUpload(boolean upload) {
        this.upload = upload;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }

    @Override
    public String call(){
        LogisticBase base = null;
        Terminal terminal = null;
        String infoTerminal;
        try {
            base = LogisticBase.getInstance();
            terminal = base.getAccessToTerminal(this);
            infoTerminal = String.valueOf(terminal.getTerminalId());
            terminal.serveLorry(this);
            return "Lorry: "+this.getLorryId() + " Terminal: " +infoTerminal;
        }finally {
            base.releaseTerminal(terminal);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lorry lorry = (Lorry) o;
        if (lorryId != lorry.lorryId) return false;
        if (spoilingProduct != lorry.spoilingProduct) return false;
        if (upload != lorry.upload) return false;
        if (size != lorry.size) return false;
        return products == lorry.products;
    }

    @Override
    public int hashCode() {
        int result = (int) (lorryId ^ (lorryId >>> 32));
        result = 31 * result + (spoilingProduct ? 1 : 0);
        result = 31 * result + (upload ? 1 : 0);
        result = 31 * result + size;
        result = 31 * result + products;
        return result;
    }
}
