package org.suns.data.collector.connector;

import org.suns.data.collector.config.WebLogicConnectorConfig;

import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.naming.Context;
import java.util.Hashtable;

public class WebLogicConnector {
    private static MBeanServerConnection connection;
    private static JMXConnector connector;
    private static final ObjectName service;

    // Initializing the object name for DomainRuntimeServiceMBean
    // so it can be used throughout the class.
    static {
        try {
            service = new ObjectName(WebLogicConnectorConfig.getServiceObjectName());
        }catch (MalformedObjectNameException e) {
            throw new AssertionError(e.getMessage());
        }
    }

    /*
   * Initialize connection to the Domain Runtime MBean Server
   */
    public static MBeanServerConnection initConnection(String hostname, int port,
                                      String username, String password) throws Exception{
        String protocol = WebLogicConnectorConfig.getProtocol();
        String jndiroot = WebLogicConnectorConfig.getJndiRoot();
        String mServer = WebLogicConnectorConfig.getmServer();

        JMXServiceURL serviceURL = new JMXServiceURL(protocol, hostname,
                port, jndiroot + mServer);
        Hashtable h = new Hashtable();
        h.put(Context.SECURITY_PRINCIPAL, username);
        h.put(Context.SECURITY_CREDENTIALS, password);
        h.put(JMXConnectorFactory.PROTOCOL_PROVIDER_PACKAGES,
                WebLogicConnectorConfig.getProtocolProviderPackage());
        connector = JMXConnectorFactory.connect(serviceURL, h);
        connection = connector.getMBeanServerConnection();

        return connection;
    }

    /*
    * Get an array of ServerRuntimeMBeans
    */
    public static ObjectName[] getServerRuntimes() throws Exception {
        return (ObjectName[]) connection.getAttribute(service,
                "ServerRuntimes");
    }

    public static void closeConnector() throws Exception{
        if(connector != null){
            connector.close();
        }
    }
}
