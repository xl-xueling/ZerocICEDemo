package com.dtstep.test.ice.PrinterServer.local.server;

import com.dtstep.test.ice.PrinterServer.Printer;
import com.zeroc.Ice.Current;

public class LocalPrinterServiceImpl implements Printer {

    @Override
    public void printStr(String str, Current current) {
        System.out.println("server receive message,msg:" + str);
    }
}
