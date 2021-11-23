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
        }finally {
            base.releaseTerminal(terminal);
        }
        return "Lorry: "+this.getLorryId() + " Terminal: " +infoTerminal;
    }
}
