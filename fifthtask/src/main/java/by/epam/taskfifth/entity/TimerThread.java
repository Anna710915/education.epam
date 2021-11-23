package by.epam.taskfifth.entity;

import java.util.TimerTask;

public class TimerThread extends TimerTask {
    @Override
    public void run() {
        LogisticBase base = LogisticBase.getInstance();
        base.checkSizeTerminals();
    }
}
