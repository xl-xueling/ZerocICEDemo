package com.dtstep.test.ice.PrinterServer.cluster.server.impl;

import com.dtstep.test.ice.PrinterServer.Printer;
import com.zeroc.Ice.Current;

public class ClusterPrinterServiceImpl implements Printer {

    @Override
    public void printStr(String str, Current current) {
        System.out.println("server receive message,msg:" + str);
    }
}
