package org.suns.data.collector.collectors;

public class AbstractDataCollector {
    protected enum HostsId{
        HOST1,
        HOST2,
        HOST3,
        HOST4,
        HOST5,
        HOST6,
        HOST7,
        HOST8
    }

    protected String[] getInspectHosts1(){
        return null;
    }    
    protected String[] getPasswords1(){
        return null;
    }
    protected String[] getUsers1(){
        return null;
    }
    protected int[] getPorts1(){
        return null;
    }

    protected String[] getInspectHosts2(){
        return null;
    }
    protected String[] getPasswords2(){
        return null;
    }
    protected String[] getUsers2(){
        return null;
    }
    protected int[] getPorts2(){
        return null;
    }

    protected String[] getInspectHosts3(){
        return null;
    }
    protected String[] getPasswords3(){
        return null;
    }
    protected String[] getUsers3(){
        return null;
    }
    protected int[] getPorts3(){
        return null;
    }

    protected String[] getInspectHosts4(){
        return null;
    }
    protected String[] getPasswords4(){
        return null;
    }
    protected String[] getUsers4(){
        return null;
    }
    protected int[] getPorts4(){
        return null;
    }

    protected String[] getInspectHosts5(){
        return null;
    }
    protected String[] getPasswords5(){
        return null;
    }
    protected String[] getUsers5(){
        return null;
    }
    protected int[] getPorts5(){
        return null;
    }

    protected String[] getInspectHosts6(){
        return null;
    }
    protected String[] getPasswords6(){
        return null;
    }
    protected String[] getUsers6(){
        return null;
    }
    protected int[] getPorts6(){
        return null;
    }

    protected String[] getInspectHosts7(){
        return null;
    }
    protected String[] getPasswords7(){
        return null;
    }
    protected String[] getUsers7(){
        return null;
    }
    protected int[] getPorts7(){
        return null;
    }

    protected String[] getInspectHosts8(){
        return null;
    }
    protected String[] getPasswords8(){
        return null;
    }
    protected String[] getUsers8(){
        return null;
    }
    protected int[] getPorts8(){
        return null;
    }

    protected String[] getInspectHosts(HostsId hostsId){
        switch (hostsId){
            case HOST1:
                return getInspectHosts1();
            case HOST2:
                return getInspectHosts2();
            case HOST3:
                return getInspectHosts3();
            case HOST4:
                return getInspectHosts4();
            case HOST5:
                return getInspectHosts5();
            case HOST6:
                return getInspectHosts6();
            case HOST7:
                return getInspectHosts7();
            case HOST8:
                return getInspectHosts8();
            default:
                return null;
        }
    }
    
    protected String[] getUsers(HostsId hostsId){
        switch (hostsId){
            case HOST1:
                return getUsers1();
            case HOST2:
                return getUsers2();
            case HOST3:
                return getUsers3();
            case HOST4:
                return getUsers4();
            case HOST5:
                return getUsers5();
            case HOST6:
                return getUsers6();
            case HOST7:
                return getUsers7();
            case HOST8:
                return getUsers8();
            default:
                return null;
        }
    }

    protected String[] getPasswords(HostsId hostsId){
        switch (hostsId){
            case HOST1:
                return getPasswords1();
            case HOST2:
                return getPasswords2();
            case HOST3:
                return getPasswords3();
            case HOST4:
                return getPasswords4();
            case HOST5:
                return getPasswords5();
            case HOST6:
                return getPasswords6();
            case HOST7:
                return getPasswords7();
            case HOST8:
                return getPasswords8();
            default:
                return null;
        }
    }
    
    protected int[] getPorts(HostsId hostsId){
        switch (hostsId){
            case HOST1:
                return getPorts1();
            case HOST2:
                return getPorts2();
            case HOST3:
                return getPorts3();
            case HOST4:
                return getPorts4();
            case HOST5:
                return getPorts5();
            case HOST6:
                return getPorts6();
            case HOST7:
                return getPorts7();
            case HOST8:
                return getPorts8();
            default:
                return null;
        }
    }
}
